# NarAT
NAR Additional Testsuite Example



Test version 1.0-SNAPSHOT

1. Go to NarAT/NAR-plugin/src/it/it0007-lib-shared
2. Run mvn clean install to produce the artifact
3. Go to NarAT/
4. export BRANCH_VERSION=1.0-SNAPSHOT
5. Run mvn clean install -Dmaster
6. Observe the output : Hello NAR LIB World!


Test version 1.1-SNAPSHOT

1. Go to NarAT/NAR-plugin/src/it/it0007-lib-shared2
2. Run mvn clean install to produce the artifact
3. Go to NarAT/
4. export BRANCH_VERSION=1.1-SNAPSHOT
5. Run mvn clean install -Dmaster
6. Observe the output : Hello again NAR LIB World!
