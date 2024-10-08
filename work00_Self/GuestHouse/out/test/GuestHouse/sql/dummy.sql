-- Insert dummy data into the GuestHouse table
INSERT INTO `guesthouse`.`GuestHouse` (`id`, `name`, `address`, `room_num`, `room_price`, `capacity`) VALUES
('GH001', '하늘정원', '서울특별시', 101, 50000, 2),
('GH002', '바다풍경', '서울특별시', 102, 45000, 2),
('GH003', '산속마을', '서울특별시', 103, 40000, 3),
('GH004', '별빛하우스', '서울특별시', 104, 55000, 4),
('GH005', '숲속의집', '서울특별시', 105, 30000, 1),
('GH006', '달빛게스트', '서울특별시', 106, 35000, 2),
('GH007', '해돋이펜션', '서울특별시', 107, 40000, 2),
('GH008', '노을리조트', '서울특별시', 108, 45000, 3),
('GH009', '구름속의집', '서울특별시', 109, 50000, 4),
('GH010', '푸른하늘', '서울특별시', 110, 60000, 2),
('GH011', '호수의집', '부산', 101, 51000, 2),
('GH012', '솔향기펜션', '부산', 102, 46000, 2),
('GH013', '달빛정원', '부산', 103, 41000, 3),
('GH014', '해변하우스', '부산', 104, 56000, 4),
('GH015', '꽃피는집', '부산', 105, 31000, 1),
('GH016', '아침햇살', '부산', 106, 36000, 2),
('GH017', '별빛속으로', '부산', 107, 41000, 2),
('GH018', '햇살마루', '부산', 108, 46000, 3),
('GH019', '바람의언덕', '부산', 109, 51000, 4),
('GH020', '시냇가', '부산', 110, 61000, 2),
('GH021', '햇살좋은집', '강원도', 101, 52000, 2),
('GH022', '바람꽃', '강원도', 102, 47000, 2),
('GH023', '산책길', '강원도', 103, 42000, 3),
('GH024', '달빛속으로', '강원도', 104, 57000, 4),
('GH025', '별빛호수', '강원도', 105, 32000, 1),
('GH026', '바다내음', '강원도', 106, 37000, 2),
('GH027', '구름위의집', '강원도', 107, 42000, 2),
('GH028', '초록숲', '강원도', 108, 47000, 3),
('GH029', '호수정원', '강원도', 109, 52000, 4),
('GH030', '바람의집', '강원도', 110, 62000, 2);


-- Insert dummy data into the Customer table
INSERT INTO `guesthouse`.`Customer` (`id`, `pass`, `name`, `phone`) VALUES
('C001', 'password1', '김철수', '010-1111-1111'),
('C002', 'password2', '이영희', '010-2222-2222'),
('C003', 'password3', '박지훈', '010-3333-3333'),
('C004', 'password4', '최민수', '010-4444-4444'),
('C005', 'password5', '한지민', '010-5555-5555'),
('C006', 'password6', '정유진', '010-6666-6666'),
('C007', 'password7', '장동건', '010-7777-7777'),
('C008', 'password8', '고소영', '010-8888-8888'),
('C009', 'password9', '유재석', '010-9999-9999'),
('C010', 'password10', '강호동', '010-1010-1010');

-- Insert dummy data into the Review table
INSERT INTO `guesthouse`.`Review` (`content`, `rating`, `Customer_id`, `GuestHouse_id`) VALUES
('정말 편안하게 쉴 수 있었어요. 방도 깨끗하고 친절했습니다.', 5, 'C001', 'GH001'),
('숙소가 정말 예쁘고 깨끗해요. 다음에 또 오고 싶어요.', 4, 'C002', 'GH002'),
('조용하고 아늑한 곳입니다. 가격도 합리적이고 좋았어요.', 4, 'C003', 'GH003'),
('뷰가 정말 끝내줍니다. 아침 햇살이 너무 아름다웠어요.', 5, 'C004', 'GH004'),
('방이 조금 좁았지만 전반적으로 만족스러웠어요.', 3, 'C005', 'GH005'),
('친절한 서비스에 정말 감동받았습니다. 강력 추천해요!', 5, 'C006', 'GH006'),
('위치가 좋아서 관광하기 편리했어요. 방도 깔끔했습니다.', 4, 'C007', 'GH007'),
('조용하고 평화로운 분위기에서 힐링할 수 있었어요.', 5, 'C008', 'GH008'),
('숙소가 너무 예쁘고 깔끔해서 기분 좋게 머물렀습니다.', 4, 'C009', 'GH009'),
('가격 대비 훌륭한 숙소였습니다. 다음에도 이용할게요.', 4, 'C010', 'GH010'),
('편안하게 쉴 수 있는 공간이었어요. 주변도 조용하고 좋아요.', 4, 'C001', 'GH011'),
('방이 넓고 깨끗해서 좋았습니다. 다시 방문하고 싶어요.', 5, 'C002', 'GH012'),
('숙소가 정말 깔끔하고 편안했어요. 추천합니다.', 5, 'C003', 'GH013'),
('위치가 좋아서 이동하기 편리했어요. 서비스도 만족스러웠습니다.', 4, 'C004', 'GH014'),
('조용하고 아늑해서 푹 쉴 수 있었어요.', 5, 'C005', 'GH015'),
('친절한 서비스에 기분 좋게 머물렀습니다.', 4, 'C006', 'GH016'),
('숙소가 정말 예쁘고 분위기 있었습니다.', 5, 'C007', 'GH017'),
('뷰가 좋고 조용해서 힐링할 수 있었어요.', 5, 'C008', 'GH018'),
('방이 조금 좁았지만 전반적으로 만족스러웠어요.', 3, 'C009', 'GH019'),
('아늑하고 조용해서 좋았습니다. 다음에도 이용할게요.', 4, 'C010', 'GH020'),
('깔끔하고 예쁜 숙소였습니다. 편안하게 잘 쉬다 갑니다.', 5, 'C001', 'GH021'),
('방이 아주 깨끗하고 따뜻했습니다. 다음에 또 오고 싶어요.', 4, 'C002', 'GH022'),
('전망이 너무 좋아서 힐링할 수 있었습니다.', 5, 'C003', 'GH023'),
('서비스가 좋아서 만족스러웠습니다.', 4, 'C004', 'GH024'),
('조용하고 평화로운 분위기에서 힐링할 수 있었습니다.', 5, 'C005', 'GH025'),
('위치가 좋아서 편리하게 이용했습니다.', 4, 'C006', 'GH026'),
('숙소가 깨끗하고 넓어서 좋았습니다.', 5, 'C007', 'GH027'),
('정말 즐거운 시간이었습니다. 강력 추천합니다.', 5, 'C008', 'GH028'),
('가격 대비 훌륭한 숙소였습니다. 재방문 의사 있습니다.', 4, 'C009', 'GH029'),
('편안하게 쉴 수 있는 공간이었습니다. 만족합니다.', 4, 'C010', 'GH030');


-- Insert dummy data into the Reservation table
INSERT INTO `guesthouse`.`Reservation` (`id`, `start_date`, `end_date`, `total_price`, `Customer_id`, `GuestHouse_id`) VALUES
(1, '2024-01-01', '2024-01-05', 200000, 'C001', 'GH001'),
(2, '2024-01-10', '2024-01-12', 90000, 'C002', 'GH002'),
(3, '2024-01-15', '2024-01-20', 250000, 'C003', 'GH003'),
(4, '2024-01-22', '2024-01-25', 150000, 'C004', 'GH004'),
(5, '2024-01-28', '2024-01-30', 100000, 'C005', 'GH005'),
(6, '2024-02-01', '2024-02-03', 90000, 'C006', 'GH006'),
(7, '2024-02-05', '2024-02-10', 300000, 'C007', 'GH007'),
(8, '2024-02-12', '2024-02-15', 120000, 'C008', 'GH008'),
(9, '2024-02-17', '2024-02-20', 150000, 'C009', 'GH009'),
(10, '2024-02-22', '2024-02-25', 160000, 'C010', 'GH010'),
(11, '2024-03-01', '2024-03-05', 220000, 'C001', 'GH011'),
(12, '2024-03-10', '2024-03-12', 95000, 'C002', 'GH012'),
(13, '2024-03-15', '2024-03-20', 260000, 'C003', 'GH013'),
(14, '2024-03-22', '2024-03-25', 155000, 'C004', 'GH014'),
(15, '2024-03-28', '2024-03-30', 105000, 'C005', 'GH015'),
(16, '2024-04-01', '2024-04-03', 92000, 'C006', 'GH016'),
(17, '2024-04-05', '2024-04-10', 310000, 'C007', 'GH017'),
(18, '2024-04-12', '2024-04-15', 125000, 'C008', 'GH018'),
(19, '2024-04-17', '2024-04-20', 155000, 'C009', 'GH019'),
(20, '2024-04-22', '2024-04-25', 165000, 'C010', 'GH020'),
(21, '2024-05-01', '2024-05-05', 225000, 'C001', 'GH021'),
(22, '2024-05-10', '2024-05-12', 97000, 'C002', 'GH022'),
(23, '2024-05-15', '2024-05-20', 265000, 'C003', 'GH023'),
(24, '2024-05-22', '2024-05-25', 160000, 'C004', 'GH024'),
(25, '2024-05-28', '2024-05-30', 110000, 'C005', 'GH025'),
(26, '2024-06-01', '2024-06-03', 94000, 'C006', 'GH026'),
(27, '2024-06-05', '2024-06-10', 315000, 'C007', 'GH027'),
(28, '2024-06-12', '2024-06-15', 130000, 'C008', 'GH028'),
(29, '2024-06-17', '2024-06-20', 160000, 'C009', 'GH029'),
(30, '2024-06-22', '2024-06-25', 170000, 'C010', 'GH030');
