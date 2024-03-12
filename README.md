Вычислитель отличий – программа, определяющая разницу между двумя структурами данных.

Возможности утилиты:
Поддержка разных входных форматов: yaml и json
Генерация отчета в виде plain text, stylish и json
Пример использования:

# формат plain
./app --format plain path/to/file.yml another/path/file.json

Property 'follow' was added with value: false
Property 'baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

# формат stylish
./app filepath1.json filepath2.json

{
  + follow: false
  + numbers: [1, 2, 3]
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {key=value}
  + setting4: blah blah
}

### Hexlet tests and linter status:
![Actions Status](https://github.com/RomanKhal/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)
![Actions Status](https://github.com/RomanKhal/java-project-71/actions/workflows/main.yml/badge.svg)
<a href="https://codeclimate.com/github/RomanKhal/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/8f8a1e2ea9d0355a7901/maintainability" /></a>
<a href="https://codeclimate.com/github/RomanKhal/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/8f8a1e2ea9d0355a7901/test_coverage" /></a>
[![asciicast](https://asciinema.org/a/K9LNUiZCWlrKuQkULQcF5Xtun.svg)](https://asciinema.org/a/K9LNUiZCWlrKuQkULQcF5Xtun)
