#!/bin/bash
export JAVA_HOME=/afs/slac/g/lcls/package/java/jdk1.8.0_144
export M2_HOME=/afs/slac/g/lcls/package/maven/3.5.0/rhel6-x86_64
export PATH=$JAVA_HOME/bin:$M2_HOME/bin:$PATH
export LD_LIBRARY_PATH=$JAVA_HOME/jre/lib/amd64:$LD_LIBRARY_PATH

