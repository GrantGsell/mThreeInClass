-- Select database to work from
USE world;

-- Activity 1a: City
SELECT * 
FROM city 
LIMIT 10;


-- Activity 1b: Country
SELECT * 
FROM country
LIMIT 10;


-- Activity 1c: Country Language
SELECT * 
FROM countrylanguage
LIMIT 10;


-- Activity 2
SELECT * 
FROM city
WHERE population < 10000
ORDER BY population DESC;


-- Activity 3
SELECT
	city.name AS CityName,
    city.district AS Region,
    city.countryCode AS Country
FROM city
ORDER BY Region, Country, CityName;


-- Activity 4 ERROR: Expecting 22 GOT 27/28
SELECT 
	country.name AS Country,
    countrylanguage.language AS Language,
    countrylanguage.percentage AS 'Percentage of Speakers'
FROM country
INNER JOIN countryLanguage ON country.code = countryLanguage.countryCode
WHERE countrylanguage.language LIKE "%French%"
HAVING countrylanguage.percentage > 0
ORDER BY countrylanguage.percentage DESC;


-- Activity 5
SELECT 
	country.name As Country,
    country.continent AS Continent,
    country.population AS Population
FROM country
WHERE indepYear IS NULL
ORDER BY Country;
    

-- Activity 6
SELECT
	country.name AS Country,
    continent AS Continent,
    cl.language AS 'Language',
    Percentage
FROM country
LEFT OUTER JOIN countrylanguage AS cl ON cl.countryCode = country.code
ORDER BY Country, Percentage DESC;

-- Activity 7
SELECT 
	country.name AS Country,
    Continent
FROM country
LEFT OUTER JOIN countryLanguage AS cl on cl.countryCode = country.code
WHERE cl.language IS NULL
ORDER BY Continent, Country;


-- Activity 8
SELECT
	country.Name AS Country,
    SUM(city.population) AS TotalPopulation
FROM country
INNER JOIN city ON city.countryCode = country.code
GROUP BY city.countryCode
ORDER BY TotalPopulation ASC;


-- Activity 9 ORDER by Alias not working when alias uses quotes
SELECT 
	Continent,
    -- IFNULL(AVG(city.population), 0) AS 'Average Population'
    CAST(IFNULL(AVG(city.population), 0) AS DECIMAL(10,3)) AS AveragePopulation
FROM country
LEFT OUTER JOIN city ON city.countryCode = country.code
GROUP BY Continent
ORDER BY AveragePopulation DESC;
-- ORDER BY CAST(IFNULL(AVG(city.population), 0) AS DECIMAL(10,3)) DESC;


-- Activity 10
SELECT
	country.Name AS Country,
    country.gnp AS GNP
FROM country
ORDER BY GNP DESC
LIMIT 10;


-- Activity 11
SELECT 
	country.Name AS Country,
	city.Name AS Capital,
    city.population AS Population,
    cl.language AS OfficialLanguage
FROM country
JOIN city ON city.countryCode = country.code
JOIN countryLanguage AS cl ON cl.countryCode = country.code
WHERE cl.isOfficial = 'T'
ORDER BY Country ASC;


-- Activity 12 CAPITAL is an INT needs to be converted to Name
SELECT 
	country.Name AS Country,
	city.Name AS Capital
FROM country
LEFT JOIN city ON city.Id = country.capital
ORDER BY Country ASC;