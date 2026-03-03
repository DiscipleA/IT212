function percentImprovement(baselineMs, optimizedMs) {
  if (baselineMs <= 0) return 0;
  return ((baselineMs - optimizedMs) / baselineMs) * 100;
}

function formatMs(ms) {
  return `${ms.toFixed(3)} ms`;
}

module.exports = { percentImprovement, formatMs };