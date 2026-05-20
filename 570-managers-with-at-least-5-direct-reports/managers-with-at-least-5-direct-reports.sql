WITH RECURSIVE manager_cte AS (

    SELECT managerId, COUNT(*) AS total_reports
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId

)

SELECT e.name
FROM Employee e
JOIN manager_cte m
ON e.id = m.managerId
WHERE m.total_reports >= 5;