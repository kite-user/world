# World API
A REST API service for querying data about countries, cities and languages

## Query for countries
- URL: */api/country
- Request body: {"countryCode": "abcxyz", "name": "abcd"}

## Query for cities
- URL: */api/city
- Request body: {"countryCode": "abcd", "name": "abcd"}

## Query for language
- URL: */api/language
- Request body: {"countryCode": "abcd"} 
