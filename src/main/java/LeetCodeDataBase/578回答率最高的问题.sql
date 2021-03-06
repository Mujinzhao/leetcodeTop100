-- //从 survey_log 表中获得回答率最高的问题，survey_log 表包含这些列：uid, action, question_id, answer_id, q_num, timestamp。 
-- //
-- // uid 表示用户 id；action 有以下几种值："show"，"answer"，"skip"；当 action 值为 "answer" 时 answer_id 非空，而 action 值为 "show" 或者 "skip" 时 answer_id 为空；q_num 表示当前会话中问题的编号。 
-- //
-- // 请编写SQL查询来找到具有最高回答率的问题。 
-- //
-- // 示例: 
-- //
-- // 输入:
-- //+------+-----------+--------------+------------+-----------+------------+
-- //| uid  | action    | question_id  | answer_id  | q_num     | timestamp  |
-- //+------+-----------+--------------+------------+-----------+------------+
-- //| 5    | show      | 285          | null       | 1         | 123        |
-- //| 5    | answer    | 285          | 124124     | 1         | 124        |
-- //| 5    | show      | 369          | null       | 2         | 125        |
-- //| 5    | skip      | 369          | null       | 2         | 126        |
-- //+------+-----------+--------------+------------+-----------+------------+
-- //输出:
-- //+-------------+
-- //| survey_log  |
-- //+-------------+
-- //|    285      |
-- //+-------------+
-- //解释:
-- //问题285的回答率为 1/1，而问题369回答率为 0/1，因此输出285。
-- // 
-- //
-- // 
-- //
-- // 注意: 回答率最高的含义是：同一问题编号中回答数占显示数的比例。 
-- //

select yesTable.question_id as survey_log
        from
(select question_id , count(*) as yesNum
from survey_log
where answer_id is not null
group by question_id) as yesTable
order by yesTable.yesNum/(select count(*) from survey_log where question_id = yesTable.question_id) desc limit 0,1