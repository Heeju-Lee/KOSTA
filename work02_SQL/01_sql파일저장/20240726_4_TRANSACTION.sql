-- 2024.07.26
/*
Transaction
: 더이상 쪼개질 수 없는 최소의 처리단위...
-- ============================
1. 원자성 :  
2. 일관성 : commit이 됐을 때만 그 단위가 마무리된다. 
3. 독립성 :
-- ============================
commit : 무사 도착했을 때 제출 
rollback : 중간에 error 발생하면 처리직전으로 돌아감
savepoint : 중간처리
-- ============================
setAutocommit(false)
setAutocommit(true)
-- ============================
*/

