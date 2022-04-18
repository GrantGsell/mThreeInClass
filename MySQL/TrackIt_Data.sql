USE trackit;

INSERT INTO Worker (FirstName, LastName)
    VALUES ('Rosemonde', 'Featherbie');

INSERT INTO Worker (FirstName, LastName)
    VALUES ('Kingsly', 'Besantie');
    
INSERT INTO Worker (FirstName, LastName) VALUES
    ('Goldi','Pilipets'),
    ('Dorey','Rulf'),
    ('Panchito','Ashtonhurst');
    
INSERT INTO Worker (FirstName, LastName)
    VALUES ('Valentino', 'Newvill');
    
INSERT INTO Worker (FirstName, LastName)
    VALUES ('Violet', 'Mercado');
    
    INSERT INTO Project (ProjectId, `Name`, DueDate)
    VALUES ('db-milestone', 'Database Material', '2018-12-31'); 
    
    INSERT INTO ProjectWorker (ProjectId, WorkerId)
    VALUES ('db-milestone', 2);
    
INSERT INTO Project (ProjectId, `Name`, DueDate)
	VALUES ('kitchen', 'Kitchen Remodel', '2025-07-15'); 
    
INSERT INTO ProjectWorker (ProjectId, WorkerId) VALUES 
    ('db-milestone', 1), -- Rosemonde, Database
    ('kitchen', 2),      -- Kingsly, Kitchen
    ('db-milestone', 3), -- Goldi, Database
    ('db-milestone', 4); -- Dorey, Database

-- Provide a Project Summary and change the DueDate.
UPDATE Project SET
    Summary = 'All lessons and exercises for the relational database milestone.',
    DueDate = '2018-10-15'
WHERE ProjectId = 'db-milestone';

-- Change Kingsly's LastName to 'Oaks'.
UPDATE Worker SET
    LastName = 'Oaks'
WHERE WorkerId = 2;    

UPDATE ProjectWorker SET
    WorkerID = '5'
WHERE WorkerId = 2;

SELECT * FROM worker;
    
SELECT * FROM Project;

SELECT * FROM ProjectWorker;