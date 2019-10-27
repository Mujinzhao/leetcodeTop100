-- Employee 表包含所有员工。Employee 表有三列：员工Id，公司名和薪水。
--
-- +-----+------------+--------+
-- |Id   | Company    | Salary |
-- +-----+------------+--------+
-- |1    | A          | 2341   |
-- |2    | A          | 341    |
-- |3    | A          | 15     |
-- |4    | A          | 15314  |
-- |5    | A          | 451    |
-- |6    | A          | 513    |
-- |7    | B          | 15     |
-- |8    | B          | 13     |
-- |9    | B          | 1154   |
-- |10   | B          | 1345   |
-- |11   | B          | 1221   |
-- |12   | B          | 234    |
-- |13   | C          | 2345   |
-- |14   | C          | 2645   |
-- |15   | C          | 2645   |
-- |16   | C          | 2652   |
-- |17   | C          | 65     |
-- +-----+------------+--------+
-- 请编写SQL查询来查找每个公司的薪水中位数。挑战点：你是否可以在不使用任何内置的SQL函数的情况下解决此问题。
--
-- +-----+------------+--------+
-- |Id   | Company    | Salary |
-- +-----+------------+--------+
-- |5    | A          | 451    |
-- |6    | A          | 513    |
-- |12   | B          | 234    |
-- |9    | B          | 1154   |
-- |14   | C          | 2645   |
-- +-----+------------+--------+

select Number.id as Id,Number.Company as Company,Number.Salary as Salary
from
(select A.Id as id,A.Company as Company, A.Salary as Salary ,count(*) as num
from Employee A left join Employee B on A.Company = B.Company
where A.Salary > B.Salary or (A.Salary = B.Salary and A.Id >= B.Id)
group by A.Id,A.Company,A.Salary) as Number ,
(select Company , count(*)/2 as num from Employee group by Company) as E
where Number.Company = E.Company and Number.num >= E.num and Number.num <= E.num + 1


比较好理解的一种解法，效率可能不是最高，但是重在思想。