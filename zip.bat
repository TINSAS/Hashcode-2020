echo on

for /f "tokens=3,2,4 delims=/- " %%x in ("%date%") do set d=%%y%%x%%z
set data=%d%

Echo zipping...

"C:\Program Files\7-Zip\7z.exe" a -tzip "D:\dmp\Test_Zipping_%d%.zip" "D:\dmp\*.dmp"

echo Done!
