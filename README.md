완성도	필수	☐ STEP 1. 상품 목록을 출력하고 입력 숫자에 따라 분기 처리했는가? yes
☐ STEP 1. Product 클래스에 상품명·가격·설명·재고수량 필드를 정의하고 List<Product>로 관리했는가? yes
☐ STEP 2. CommerceSystem 클래스를 만들고 start()에서 입력·반복·종료 흐름을 처리했는가? yes
☐ STEP 2. List<Product>를 생성자 주입으로 CommerceSystem에 전달했는가? yes
☐ STEP 3. Category 클래스를 만들어 List<Product>와 카테고리 이름을 관리했는가? yes
☐ STEP 3. Customer 클래스에 고객명·이메일·등급 필드를 정의했는가? yes
☐ STEP 4. 모든 필드를 private으로 막고 Getter/Setter로만 접근하도록 캡슐화했는가? yes
	도전	☐ Lv1. 장바구니 추가·조회 기능과 잘못된 입력에 대한 예외 처리를 구현했는가? yes -> try catch X -> if문으로 처리
☐ Lv1. 담을 때 재고를 확인하고, 주문 확정 시 재고를 차감했는가? yes
☐ Lv1. 장바구니 내역과 총 금액을 출력하고 주문 후 장바구니를 초기화했는가? yes
☐ Lv2. 관리자 비밀번호 인증(3회 실패 시 메인 복귀)을 구현했는가? yes
☐ Lv2. 카테고리별 상품 추가·수정·삭제와 중복/삭제 동기화 처리를 구현했는가? yes
☐ Lv3. Grade Enum(BRONZE/SILVER/GOLD/PLATINUM)으로 등급별 할인율을 계산했는가? yes
☐ Lv3. stream().filter()로 가격대 필터링과 장바구니 항목 제거를 구현했는가? yes
이해도	필수	☐ 각 객체(Product/Category/Customer/CommerceSystem)의 역할과 책임(R&R) 을 설명할 수 있는가? yes
☐ new 키워드와 생성자 주입을 통해 객체 협력 관계를 구성한 이유를 설명할 수 있는가? yes
☐ 캡슐화가 왜 필요한지, 직접 필드 접근과 비교해 장점을 말할 수 있는가? yes
☐ TIL에 트러블슈팅 과정(문제 → 원인 분석 → 해결)을 기록했는가? yes
	도전	☐ 단일 책임 원칙(SRP) 관점에서 클래스 분리 근거를 설명할 수 있는가? yes
☐ Enum + 람다/스트림 조합이 if-else 분기 대비 가지는 이점을 설명할 수 있는가? yes
☐ 예외 상황(재고 부족, 잘못된 입력, 중복 상품 등)을 어떤 전략으로 처리했는지 설명할 수 있는가? yes
우수성	필수	☐ README에 프로젝트 개요·실행 방법·주요 기능을 정리했는가? Not yet
☐ 클래스/메서드/변수명이 역할을 직관적으로 드러내는가? maybe yes
	도전	☐ 디렉터리·파일이 도메인(Product/Category/Customer/System 등)별로 분리되어 있는가? yes
☐ 핵심 로직에 의도를 보조 설명하는 주석을 적정량 작성했는가? yes
☐ 특수 상황(재고 0, 비밀번호 실패, 빈 장바구니 주문 등)에 대한 예외 처리를 2가지 이상 구현했는가? yes
☐ 커밋 컨벤션(feat/fix/refactor 등)을 지킨 커밋이 10회 이상인가? No
