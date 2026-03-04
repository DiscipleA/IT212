const { spawnSync } = require("node:child_process");
const path = require("node:path");

function jarPath() {
  // from js/ to java/target/...
  return path.resolve(__dirname, "../../java/target/insertion-sort-engine-1.0.0.jar");
}

function runJava(requestObj) {
  const input = JSON.stringify(requestObj);

  const proc = spawnSync("java", ["-jar", jarPath()], {
    input,
    encoding: "utf-8",
    maxBuffer: 10 * 1024 * 1024
  });

  if (proc.error) throw proc.error;

  const out = (proc.stdout || "").trim();
  if (!out) throw new Error("No output from Java process.");

  let parsed;
  try {
    parsed = JSON.parse(out);
  } catch {
    throw new Error("Java returned non-JSON output:\n" + out);
  }

  if (proc.status !== 0 || parsed.error) {
    throw new Error(parsed.message || "Java process failed.");
  }

  return parsed;
}

function sortWithJava(algorithm, data) {
  return runJava({ mode: "sort", algorithm, data });
}

function stabilityDemo() {
  return runJava({ mode: "stabilityDemo", algorithm: "regular", data: [] });
}

module.exports = { sortWithJava, stabilityDemo };