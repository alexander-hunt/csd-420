Set-Location $PSScriptRoot

Write-Host "Compiling UnitTestWordOrchestrator.java and WordOrchestrator.java..."
javac UnitTestWordOrchestrator.java WordOrchestrator.java

Write-Host "Running UnitTestWordOrchestrator..."
java UnitTestWordOrchestrator

Write-Host "Running WordOrchestrator..."
java WordOrchestrator
