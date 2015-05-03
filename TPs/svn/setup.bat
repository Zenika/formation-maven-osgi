:: This script proceeds to local svn repository setup

set SVN_REPO="C:/training/svnrepo"
set PROJECT_HOME="C:/training/resanet"
set WORK_DIR="C:/training/work"

svnadmin create %SVN_REPO%
svn mkdir "file:///%SVN_REPO%/trunk" -m "Initial trunk"
svn mkdir "file:///%SVN_REPO%/tags" -m "Initial tags"
svn import %PROJECT_HOME% "file:///%SVN_REPO%/trunk/resanet" -m "Import resanet"

mkdir %WORK_DIR%
svn co "file:///%SVN_REPO%/trunk/resanet" %WORK_DIR%
