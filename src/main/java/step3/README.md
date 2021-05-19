# Racing Car 구현 기능 목록

### 1. 0~9 사이의 난수 생성 기능

- MovementConditionProvider 클래스
- Random 클래스의 nextInt() 메소드를 이용해 0~9 사이의 난수 생성

---

### 2. 주어진 수에 따라 차량 이동 가능 여부 판단 기능

- MovementDecisionMaker 클래스
- MovementConditionProvider 클래스로부터 주어진 수가 4 이상일 경우 이동 가능, 4 미만인 경우 이동 불가능 판단

---

### 3. 차량 이동 기능

- Car 클래스
- MovementDecisionMaker 클래스로부터 이동 가능 판단을 받을 시 이동

---

### 4. 입력 기능

- InputView 클래스
- 사용자로부터 몇 대의 자동차로 몇 번의 이동을 할 것인지 입력

---

### 5. 차량 생성 기능

- RacingManagement 클래스
- InputView로부터 받은 자동차 대수 만큼의 Car 인스턴스 생성

---

### 6. 경주 기능

- RacingManagement 클래스
- InputView로부터 받은 이동 횟수만큼 각각의 Car 인스턴스 이동

---

### 7. 출력 기능

- OutputView 클래스
- RacingManagement 클래스가 경주를 진행하면서 한 번 이동이 끝날 때마다 결과 출력