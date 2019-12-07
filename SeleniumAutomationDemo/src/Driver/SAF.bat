@echo off

set path=C:\Program Files\Java\jdk1.7.0_02\bin;D:\SAF;C:\apache-ant-1.8.4\bin;
d:
cd D:\SAF
ant -buildfile SAF.xml 
pause