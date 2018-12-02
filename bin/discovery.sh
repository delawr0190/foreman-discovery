#!/bin/bash

DISCOVERY_HOME=$(cd `dirname $0`/..; pwd)

java \
    -cp "$DISCOVERY_HOME/lib/*" \
    mn.foreman.discovery.Main