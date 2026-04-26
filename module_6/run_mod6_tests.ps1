# Compile all Java files in module_6 and run the unit test
$sourceFiles = @(
    "comparable_interface.java",
    "comparator_interface.java",
    "unit_test_mod6.java"
)

Write-Host "Compiling module_6 Java files..."
javac $sourceFiles

if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed."
    exit $LASTEXITCODE
}

Write-Host "Running unit_test_mod6..."
java unit_test_mod6

exit $LASTEXITCODE
