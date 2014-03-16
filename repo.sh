#!/bin/sh

echo 'Create a repository of all versions.'

mvn clean

OLD_VERS=('v3.2.6' 'v3.2.7' 'v3.2.8' 'v4.0.0' 'v4.0.1')
for v in ${OLD_VERS[@]}; do
  mvn deploy -P $v
done

mvn deploy
