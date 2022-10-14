# 프로젝트 설명
### exitCo [주변 대피소 찾기] 

### 개발 목적
* 2019년에 큰 산불재해가 있었는데 국가는 **긴급재난문자**로 시민들에게 대피명령을 내렸다.
하지만 대피장소로 지정된 장소가 사용할 수 없는 상태여서 국가가 피난장소의 상태를 정확하게 알지 못한다는 **취약점**을 발견했다. 이를 보완하고자 시민들이 주변 대피소를 빠르게 찾을 수 있고, 해당 대피소에 대한 **커뮤니티**가 존재하면 긴급재난문자에 의존하지 않고 시민들이 판단하여 안전하게 대피할 수 있다고 생각하여 개발하였다.

* 이는 **대학 팀 프로젝트**로 진행하였으나, 아이디어는 좋은데 완성도가 매우 떨어져 아쉬운 마음에 **Restful API**, **Spring Boot**와 **JPA**를 학습하기 위해 재구축하게 되었다. 

### 프로젝트 구성
* 인원 : 1

* 프로젝트 기간 : 2022.06.30 ~ 2022.07.26 (수정부분이 생겨 2022.08.18 ~ 2022.08.20까지 추가작업)

* Stack
  * Back-end : JAVA
  * Front-end : HTML, CSS, JS
  * Framwork : Spring Boot
  * ORM : JPA
  * DB : Mysql
  
### 타임라인
* 1주차 : 카카오맵 api 불러와 대피소 api에서 가져온 좌표로 마커 생성하여 화면에 뿌려주기
* 2주차 : 마커들에 클릭이벤트 입히기
* 3주차 : 스프링 시큐리티를 이용하여 로그인 구현
* 4주차 : 각 대피소에 대한 커뮤니티 구현(게시글 CRUD) + 페이징
* 추가작업 : ui 이상한것, 수정부분에서 오류 생기는것 처리 완료

### 아쉬운점
**AWS&freenom**을 사용해서 서비스를 하려고 했으나, 오픈 API의 모든 대피소 데이터를 가져왔지만 대피소의 **정확한 좌표**가 나오는 데이터가 없어서 구현하긴 했지만, **부정확한 정보**를 유저들이 사용할 수 있으므로 서비스 하지 못했다. 배열로 예를 들면 인덱스 1 위치에 있어야하는 장소가 4나 5에 위치함. 





