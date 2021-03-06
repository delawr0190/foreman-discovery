# foreman-discovery

## Status ##

[![Build Status](https://travis-ci.com/delawr0190/foreman-discovery.svg?branch=master)](https://travis-ci.com/delawr0190/foreman-discovery)

## Discovery ##

foreman-discovery provides a Java application that will query a cgminer-based miner running at the desired IP and port (prompted at runtime, but `port` is typically `4028`).  The following commands are executed against the miner API:

```
{"command":"version"}
{"command":"summary"}
{"command":"stats"}
{"command":"devs"}
{"command":"pools"}
```

Their responses are placed into `version.json`, `summary.json`, `stats.json`, `devs.json`, and `pools.json`, respectively.

### Windows

1. Download and extract discovery [(latest)](https://github.com/delawr0190/foreman-discovery/releases).
2. Run `discovery.bat`
3. Remove your wallet address from `pools.json`

### Linux

1. Download and extract discovery [(latest)](https://github.com/delawr0190/foreman-discovery/releases).
2. Run `discovery.sh`
3. Remove your wallet address from `pools.json`

## License ##

Copyright © 2018, [OBM LLC](https://obm.mn/).  Released under the [GPL-3.0 License](LICENSE).
