# foreman-discovery

foreman-discovery provides a Java application that will query a cgminer running at the desired IP and port (prompted at runtime, but `port` is typically `4028`).  The following commands are executed against the cgminer API:

```
{"command":"summary"}
{"command":"stats"}
{"command":"pools"}
```

Their responses are placed into `summary.json`, `stats.json`, and `pools.json`, respectively.

## Windows

1. Download and extract discovery [(latest)](https://github.com/delawr0190/foreman-discovery/releases).
2. Run `run.bat`
3. Remove your wallet address from `pools.json`

## Linux

1. Download and extract discovery [(latest)](https://github.com/delawr0190/foreman-discovery/releases).
2. Run `run.sh`
3. Remove your wallet address from `pools.json`

## License ##

Copyright © 2018, [OBM LLC](https://obm.mn/).  Released under the [GPL-3.0 License](LICENSE).
