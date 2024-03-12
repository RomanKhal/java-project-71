test_Report:
	cd app/ &&  gradle jacocoTestReport

run-dist:
	./app/build/install/app/bin/app -h
	./app/build/install/app/bin/app ./app/src/test/resources/fixtures/file1.json ./app/src/test/resources/fixtures/file2.json
	./app/build/install/app/bin/app -f plain ./app/src/test/resources/fixtures/file1.yml ./app/src/test/resources/fixtures/file2.yml
	./app/build/install/app/bin/app -f json ./app/src/test/resources/fixtures/file1.yml ./app/src/test/resources/fixtures/file2.yml



