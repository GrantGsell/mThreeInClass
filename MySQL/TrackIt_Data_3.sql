-- Data collection from trackit to practice GROUP BY and Aggregate queries
use trackit;

-- Exercise 1: Count 543 VALUES
SELECT COUNT(taskID)
FROM task;

-- Exercies 2: Count v2, 543 values
SELECT COUNT(*)
FROM Task;

-- Exercise 3: Count differeing due to null values not being counted
SELECT COUNT(TaskStatusId)
FROM Task;

-- Exercise 4: Group By
SELECT
    IFNULL(s.Name, '[None]') StatusName,
    IFNULL(s.isResolved, 0) IsResolved,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.Name, s.isResolved
ORDER BY s.Name;

-- Exercise 5: Group By vs Distinct, same results
SELECT DISTINCT
    p.Name ProjectName,
    p.ProjectId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
ORDER BY p.Name;

SELECT
    p.Name ProjectName,
    p.ProjectId,
    COUNT(p.Name) as 'Name Instances'
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.Name
ORDER BY p.Name;

-- Exercise 6: Having Clause
SELECT
    CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    SUM(t.EstimatedHours) TotalHours
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Task t ON pw.WorkerId = t.WorkerId
    AND pw.ProjectId = t.ProjectId
GROUP BY w.WorkerId, w.FirstName, w.LastName
HAVING SUM(t.EstimatedHours) >= 100
ORDER BY SUM(t.EstimatedHours) DESC;