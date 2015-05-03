#! /usr/bin/env sh

# This script proceeds to local svn repository setup

PROJECT_HOME=~/zenika/training/prepa/maven/resanet
SVN_REPO=~/svnrepo
WORK_DIR=~/work

svnadmin create $SVN_REPO
svn mkdir "file://$SVN_REPO/trunk" -m "Initial trunk"
svn mkdir "file://$SVN_REPO/tags" -m "Initial tags"
svn import $PROJECT_HOME "file://$SVN_REPO/trunk/resanet" -m "Import resanet"

mkdir -p $WORK_DIR
svn co "file://$SVN_REPO/trunk/resanet" $WORK_DIR