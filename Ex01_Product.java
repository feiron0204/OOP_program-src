
/*
A라는 전자제품 매장이 오픈되면 
[클라이언트 요구사항]
가전제품은  제품의 가격 , 제품의 포인트 정보를 공통적으로 가지고 있습니다
각각의 가전제품은 제품별 고유한 이름을 가지고 있다
ex)
각각의 전자제품은 이름을 가지고 있다(ex: Tv , Audio , Computer)
각각의 전자제품은 다른 가격을 가지고 있다(Tv:5000, Audio:6000 ....)
제품의 포인트는 가격의 10% 적용한다
 
시뮬레이션 시나리오
구매자 : 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다 
예를 들면 : 10만원  , 포인트 0
구매자는 제품을 구매할 수 있다 , 구매행위를 하게되면 가지고 있는 돈은  감소하고 포인트는 올라간다
구매자는 처음 초기 금액을 가질 수 있다
 
*/
class Product {
	int price;
	int bonuspoint;

	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class KtTv extends Product {
	// 가격정보 부모
	KtTv() {
		super(500);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	// 가격정보 부모
	Audio() {
		super(100);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product {
	// 가격정보 부모
	NoteBook() {
		super(150);
	}

	@Override
	public String toString() {
		return "NoteBook";
	}
}

/*
 * 하와이 휴가
 * 
 * 공식오픈 매장에 1000개의 제품이 추가 (POS 구축) 자동 등록 매장에 1000개의 제품이 전시
 * 
 * 고객 >> 구매 >> 3개 >> 997개의 판매 불가
 * 
 * 전화 >> 욕(...) >> 친구 >> PC >> 접속 >> 997개의 함수 >> 휴가 ...비행기 .....
 * 
 * 하와이 즐거운 휴가 1. 모든 제품은 Product 상속 2. 함수의 통합 3. 한개의 함수가 모든 제품의 판매 담당 4. 다형성
 * 
 * 카트(Cart) 카트에는 매장에 있는 모든 전자제품을 담을 수 있다. 카트의 크기는 고정되어 있다 (10개) :1개, 2개 담을수있고 최대
 * 10개 까지 담을수있다. 고객이 물건을 구매 하면 ... 카트에 담는다
 * 
 * 계산대에 가면 전체 계산 계산기능이 필요 summary()기능 추가해 주세요 당신이 구매한 물건이름 과 가격정보 나열 총 누적금액 계산
 * 출력
 * 
 * hint) 카트 물건을 담는 행위(Buy() 함수안에서 cart 담는것을 만들기) hint) Buyer .. >> summary()
 * main 함수에서 계산할때
 */

class Buyer {
	int money;
	int bonuspoint;
//	Product[] cart = new Product[10];
//	int index = 0;
	//초기값도 생성자로 빼주는게 좋음!
	Product[] cart;
	int index;
	
	Buyer(){
		this.money=1000;
		this.cart=new Product[10];
		this.index=0;
	}
	// 구매자는 구매 행위를 할 수 있다 (기능)
	// 구매행위(잔액 - 제품의 가격 , 포인트 정보 갱신(증가)
	// *******구매자는 매장에 있는 모든 물건을 구매할 수 있다 ***********

	void ProBuy(Product p) {
		if (this.money < p.price) {
			System.out.println("고객님 잔액이 부족합니다 ^^!" + this.money);
			return; // 함수의 종료 ^^(구매행위 종료)
		}
		// 실 구매 행위
		if (index < 10) {
			this.money -= p.price; // 잔액
			this.bonuspoint += p.bonuspoint; // 누적
			System.out.println("구매한 물건은 : " + p.toString());
			this.cart[index++] = p;
		} else {
			System.out.println("카트가 가득차서 물건을 더 구매할수 없습니다.");
		}
	}

//	void KttvBuy(KtTv n) { //구매자가 어떤 물건을 정보를 알아야 (그 물건의 가격정보 얻어올 수 있다)
//		if(this.money < n.price) {
//			System.out.println("고객님 잔액이 부족합니다 ^^!" + this.money);
//			return; //함수의 종료 ^^(구매행위 종료)
//		}
//		//실 구매 행위
//		this.money -= n.price; //잔액
//		this.bonuspoint += n.bonuspoint; //누적
//		System.out.println("구매한 물건은 : " + n.toString());
//		
//	}
//	
//	void NoteBook(NoteBook n) { //구매자가 어떤 물건을 정보를 알아야 (그 물건의 가격정보 얻어올 수 있다)
//		if(this.money < n.price) {
//			System.out.println("고객님 잔액이 부족합니다 ^^!" + this.money);
//			return; //함수의 종료 ^^(구매행위 종료)
//		}
//		//실 구매 행위
//		this.money -= n.price; //잔액
//		this.bonuspoint += n.bonuspoint; //누적
//		System.out.println("구매한 물건은 : " + n.toString());
//		
//	}
//	
//	
//	void Audio(Audio n) { //구매자가 어떤 물건을 정보를 알아야 (그 물건의 가격정보 얻어올 수 있다)
//		if(this.money < n.price) {
//			System.out.println("고객님 잔액이 부족합니다 ^^!" + this.money);
//			return; //함수의 종료 ^^(구매행위 종료)
//		}
//		//실 구매 행위
//		this.money -= n.price; //잔액
//		this.bonuspoint += n.bonuspoint; //누적
//		System.out.println("구매한 물건은 : " + n.toString());
//		
//	}

	// 냉장고 판매 함수
	// 드라이기 판매 함수 ..

	int summary() {
		int sum = 0;
		for (int i = 0; i < index; i++) {
			System.out.println("물건이름: " + cart[i].toString() + "\t물건가격: " + cart[i].price);
			sum += cart[i].price;
		}
		System.out.println("--------------------------------------------------");
		System.out.println("총 금액: " + sum);
		return sum;
	}
}

public class Ex01_Product {

	public static void main(String[] args) {
		Buyer b=new Buyer();
		b.ProBuy(new Audio());
		b.ProBuy(new Audio());
		b.ProBuy(new KtTv());
		b.ProBuy(new NoteBook());
		
		b.summary();

	}

}