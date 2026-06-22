package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private final List<Category> categories; // Category 클래스를 List로 관리 -> Product는 Category로 넘어감
    private final Cart cart; // Cart 클래스 주입

    public CommerceSystem(List<Category> categories, Cart cart) { // Main에서 카테고리 객체 생성하고 totalCategory에 담은 것을 받아야 함.
        this.categories = categories;
        this.cart = cart; // 생성자에 cart 가져오기
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categories.size(); i++) {
                Category ca = categories.get(i);
                System.out.println((i + 1) + "." + ca.getCategoryName());
            }
            System.out.println("0. 종료하기   | 프로그램 종료");
            // Lv2 관리자모드
            System.out.println("6. 관리자모드");

            // 장바구니가 들어있는지 확인
            boolean isCartNotEmpty = !cart.getCartList().isEmpty();

            // 장바구니에 상품이 들어 있으면
            if (isCartNotEmpty) {
                System.out.println("[ 주문 관리 ]");
                System.out.println("4. 장바구니 확인    |  장바구니를 확인 후 주문 합니다.");
                System.out.println("5. 주문 취소       |  진행중인 주문을 취소합니다.");
            }

            System.out.print("아래 메뉴를 선택해주세요");
            int selectMain = sc.nextInt();

            if (selectMain == 0) {
                System.out.println("프로그램을 종료 합니다.");
                break;
            } else if (selectMain >= 1 && selectMain <= categories.size()) {
                Category selectCategory = categories.get(selectMain - 1); // 인덱스가 0부터 시작이라서 1을 빼줘야 한다.
                showCategoryMenu(selectCategory, sc);

            } else if (selectMain == 4 || selectMain == 5) {
                if (!isCartNotEmpty) {
                    System.out.println("장바구니가 비어있습니다 !!");
                    continue;
                }
                if (selectMain == 4) {
                    // 카트 확인하는 메소드 호출
                    checkCartAndOrder(sc);
                } else if (selectMain == 5) {
                    // 주문 취소하는 메소드 호출
                    cancelOrder(sc);
                }
                // 관리자 모드
                else if (selectMain == 6) {
                    System.out.println("관리자 비밀번호를 입력해주세요:");
                    // 여기에 관리자 비밀번호 일치 함수 넣어주고
                    // authenticateAdmin(sc);
                }

            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }


    private void showCategoryMenu(Category category, Scanner sc) {
        while (true) {
            System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");

            List<Product> products = category.getProducts(); // category객체에서 products list를 꺼냄

            for (int i = 0; i < products.size(); i++) { // products의 사이즈만큼 모두 출력
                Product p = products.get(i);
                System.out.println((i + 1) + ". " + p.getProductName() + "|" + p.getPrice() + "원 |" + p.getProductDescription());
            }
            System.out.println("0. 뒤로가기");
            System.out.print("선택: ");

            int select = sc.nextInt();

            if (select == 0) {
                System.out.println("메인으로 돌아갑니다.");
                break;

            } else if (select >= 1 && select <= products.size()) {
                Product selectedProduct = products.get(select - 1); // productName의 인덱스가 0부터 시작이라서 1을 빼줘야 한다.
                System.out.println("선택하신 상품은 : " + selectedProduct.getProductName() + " | " + selectedProduct.getPrice() + "원 | " + selectedProduct.getProductDescription() + " | 재고 : " + selectedProduct.getQuantity() + "개");
                System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인         2. 취소");

                int cartChoice = sc.nextInt();

                if (cartChoice == 1) {
                    // 카트 addItem을 가져온다.
                    cart.addItem(selectedProduct.getProductName(), selectedProduct.getPrice(), 1);
                    System.out.println(selectedProduct.getProductName() + "가 장바구니에 추가되었습니다.");
                    break; // 주문 관리 메뉴를 보여줘야 하므로
                } else if (cartChoice == 2) {
                    System.out.println("장바구니에 상품 추가를 취소했습니다.");
                }

                break;

            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }

    public void checkCartAndOrder(Scanner sc) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ 장바구니 내역 ]");

        int totalPrice = 0;
        List<ShoppingCart> shoppingCartList = cart.getCartList(); // 쇼핑카트 호출

        for (ShoppingCart item : shoppingCartList) {
            int itemTotal = item.getPrice() * item.getQuantity();
            totalPrice += itemTotal;

            System.out.println(item.getProductName() + " | " + item.getPrice() + "원 | 수량 : " + item.getQuantity() + "개");

        }

        System.out.println("[ 총 주문 금액 ]");
        System.out.println(totalPrice + "원");
        System.out.println("1. 주문 확정     2. 메인으로 돌아가기");

        int orderChoice = sc.nextInt();
        if (orderChoice == 1) { // Enum으로 유저등급 적용
            System.out.println("고객 등급을 입력해주세요.");
            System.out.println("1. BRONZE   :  0% 할인");
            System.out.println("2. SILVER   :  5% 할인");
            System.out.println("3. GOLD     : 10% 할인");
            System.out.println("4. PLATINUM : 15% 할인");

            // UserGrade selectedGrade; // 이렇게 써도 되지만 초기화 시키는걸 추천 받음
            UserGrade selectedGrade = UserGrade.BRONZE; // 초기화를 시키고

            int gradeChoice = sc.nextInt();
            if (gradeChoice == 1) {
                selectedGrade = UserGrade.BRONZE;
            } else if (gradeChoice == 2) {
                selectedGrade = UserGrade.SILVER;
            } else if (gradeChoice == 3) {
                selectedGrade = UserGrade.GOLD;
            } else if (gradeChoice == 4) {
                selectedGrade = UserGrade.PLATINUM;
            }

            // totalPrice 활용해서
            int rate = selectedGrade.getDiscountRate();
            int discountAmount = totalPrice * rate / 100;
            int finalPrice = totalPrice - discountAmount;

            System.out.println("주문이 완료되었습니다 !!!");
            System.out.println("할인 전 금액 : " + totalPrice + "원");
            System.out.println(selectedGrade.name() + " 등급 할인(" + rate + "%) : " + discountAmount + "원");
            System.out.println("최종 결제 금액 : " + finalPrice + "원");


            for (ShoppingCart item : shoppingCartList) { // 주문 확정이니까 재고 처리 해주기
                reduceProductStock(item.getProductName(), item.getQuantity());
            }

            shoppingCartList.clear(); // 주문이 완료되었으니 장바구니는 비어주자

            System.out.println("주문이 완료되었습니다! 총 금액 : " + totalPrice + "원");

        } else {
            System.out.println("메인 화면으로 돌아갑니다.");
        }
    }

    private void reduceProductStock(String productName, int quantity) {

        for (Category c : categories) {
            for (Product p : c.getProducts()) {
                if (p.getProductName().equals(productName)) { // Product 이름이 일치하면
                    int oldStock = p.getQuantity();
                    int newStock = oldStock - quantity;

                    p.setQuantity(newStock); // 기존 재고- 수량을 뺀 것을 Product Quantity에 넣어준다

                    System.out.println(productName + " 재고가" + oldStock + "개" + newStock + "개로 업데이트되었습니다.");

                }
            }
        }
    }

    public void cancelOrder(Scanner sc) {
        cart.getCartList().clear();
        System.out.println("장바구니를 비웁니다.");
    }

    // 패스워드 일치 검사 메서드
    public void authenticateAdmin(Scanner sc) {
        int failCount = 0;

        while (failCount < 3) {
            System.out.println("관리자 비밀번호를 입력해주세요 : ");
            String inputPassword = sc.next();       // 비밀번호 입력 받고
            if (inputPassword.equals("admin123")) { // 입력한 비밀번호가 "admin123"이랑 같으면
                showAdminMenu(sc);                  // 관리자메뉴로
                return;                             // else로 안 넘어가게 return
            } else {
                failCount++; // 실패 횟수 증가
                System.out.println("비밀번호가 틀렸습니다. (현재 실패 횟수 : " + failCount + "번/3번)");
            }
        }
        System.out.println("비밀번호 3회 입력 실패하여 메인으로 돌아갑니다.");
    }

    public void showAdminMenu(Scanner sc) {
        while (true) {
            System.out.println("[ 관리자 모드 ]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 수정");
            System.out.println("3. 상품 삭제");
            System.out.println("4. 전체 상품 현황");

            System.out.println("0. 메인으로 돌아가기");

            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("메인으로 돌아갑니다.");
                break;
            } else if (choice == 1) {
                // 상품 추가
                addProductAdmin(sc);
            } else if (choice == 2) {
                // 상품 수정
                modifyProductAdmin(sc);
            } else if (choice == 3) {
                System.out.println("상품 삭제");
            } else if (choice == 4) {
                System.out.println("전체 상품 현황");
            }
        }
    }

    public void addProductAdmin(Scanner sc) {
        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");

        // 카테고리를 보여준다
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getCategoryName()); // 똑같지?
        }
        int categoryChoice = sc.nextInt();

        // 선택한 카테고리 꺼내기
        Category selectedCategory = categories.get(categoryChoice - 1);
        List<Product> products = selectedCategory.getProducts(); // 선택한 카테고리의 product list

        // 새 상품 정보 입력
        System.out.println(" [ " + selectedCategory.getCategoryName() + " 카테고리에 상품 추가 ] ");
        System.out.print("상품명을 입력해주세요 : ");
        String addProductName = sc.next();
        System.out.print("가격을 입력해주세요 : ");
        int addProductPrice = sc.nextInt();
        System.out.print("상품 설명을 입력해주세요 : ");
        String addProductDescription = sc.next();
        System.out.print("재고수량을 입력해주세요 : ");
        int addProductQuantity = sc.nextInt();

        // 중복 검사
        for (int i = 0; i < products.size(); i++) { // 이것도 똑같지?
            Product p = products.get(i);

            if (p.getProductName().equals(addProductName)) { // Product 클래스에 productsName이랑 addProductName이 같으면
                System.out.println("해당 상품은 이미 존재 합니다.");
                return;
            }
        }
        // 받은 정보들을 객체로 생성
        Product newProduct = new Product(addProductName, addProductPrice, addProductDescription, addProductQuantity);

        System.out.println(addProductName + " | " + addProductPrice + "원" + " | " + addProductDescription + " | " + "재고 : " + addProductQuantity + "개");
        System.out.println("위 정보로 상품을 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        int choice = sc.nextInt();
        if (choice == 1) {
            products.add(newProduct); // 선택한 카테고리의 product list에 방금 생성한 객체를 add
        } else {
            return;
        }

    }

    public void modifyProductAdmin(Scanner sc) {
        System.out.println("수정 할 상품명을 입력해주세요 : ");
        String modifyProductName = sc.next();

        // 이중 for문을 이렇게 활용하는 거 처음 해봄.. 학교에서 별 그리기 같은거나 해봤지...
        for (Category c : categories) { // 카테고리 클래스와
            for (Product p : c.getProducts()) { // Product 클래스에서 Products 모두 검색

                if (p.getProductName().equals(modifyProductName)) {
                    System.out.println("현재 상품 정보 : " + p.getProductName() + " | " + p.getPrice() + "원 | " + p.getProductDescription() + " | 재고 : " + p.getQuantity() + "개");
                    System.out.println("수정할 항목을 선택해주세요 : ");
                    System.out.println("1. 가격");
                    System.out.println("2. 설명");
                    System.out.println("3. 재고수량");

                    int modifyChoice = sc.nextInt();
                    if (modifyChoice == 1) {
                        System.out.println("현재 가격 : " + p.getPrice());
                        System.out.println("새로운 가격을 입력해주세요 : ");
                        int modifyPrice = sc.nextInt();
                        System.out.println(p.getProductName() + "의 가격이 " + p.getPrice() + "원 -> " + modifyPrice + "원으로 수정되었습니다.");
                        p.setPrice(modifyPrice); // Product 클래스 Price의 setter !!! 에 저장한다.
                    } else if (modifyChoice == 2) {
                        System.out.println("현재 상품 설명 : " + p.getProductDescription());
                        System.out.println("새로운 설명을 입력해주세요 : ");
                        String modifyDescription = sc.next();
                        System.out.println(p.getProductName() + "의 설명이 " + p.getProductDescription() + " -> " + modifyDescription + "'으로 수정되었습니다.");
                        p.setProductDescription(modifyDescription);
                    } else if (modifyChoice == 3) {
                        System.out.println("현재 재고수량 : " + p.getQuantity());
                        System.out.println("새로운 재고 수량을 입력해주세요 : ");
                        int modifyQuantity = sc.nextInt();
                        System.out.println(p.getProductName() + "의 수량이 " + p.getQuantity() + "개 -> " + modifyQuantity + "개로 수정되었습니다.");
                        p.setQuantity(modifyQuantity);
                    } else {
                        return;
                    }

                }
            }
        }
    }

    public void removeProductAdmin(Scanner sc) {
        System.out.println("삭제 할 상품명을 입력 해주세요");
        String removeProductName = sc.next();

        for (Category c : categories) {
            List<Product> products = c.getProducts(); // Product 클래스에 있는 Products 리스트를 꺼내온다

            // 왜 거꾸로 검색해야되는지 몰랐다.
            for (int i = products.size() - 1; i >= 0; i--) { // 삭제할때는 처음부터 검색하다가 중간에 삭제하면 현재 인덱스를 잃어버리는 java의 특징이 있어서 뒤에서부터 검색하는게 맞다.

                if (products.get(i).getProductName().equals(removeProductName)) {
                    System.out.println(removeProductName + "을 정말 삭제하시겠습니까??");
                    System.out.println("1. 삭제       2. 취소");
                    int choice = sc.nextInt();

                    if (choice == 1) {
                        products.remove(i);
                        System.out.println("상품이 삭제되었습니다.");

                        // 장바구니에서도 삭제하기
                        List<ShoppingCart> cartList = cart.getCartList(); // 장바구니 가져오고

                        for (int j = cartList.size() - 1; j >= 0; j--) { // cartList에서 removeProductName과 일치하는 것을 remove 한다.
                            if (cartList.get(j).getProductName().equals(removeProductName)) {
                                cartList.remove(j);
                                System.out.println("장바구니에서도 삭제 완료 !!");
                            }
                        }
                    } else {
                        System.out.println("삭제취소를 선택하셨습니다.");
                    }
                    return;

                }
            }
        }
        System.out.println("해당 상품을 찾을 수 없습니다.");
    }


}




