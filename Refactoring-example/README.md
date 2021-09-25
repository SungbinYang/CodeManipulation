## 리플렉션 API : 클래스 정보 조회
- 리플렉션의 시작은 Class<T>
  * https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html
 
- Class<T>에 접근하는 방법
  * 모든 클래스를 로딩 한 다음 Class<T>의 인스턴스가 생긴다. “타입.class”로 접근할 수 있다.
  * 모든 인스턴스는 getClass() 메소드를 가지고 있다. “인스턴스.getClass()”로 접근할 수 있다.
  * 클래스를 문자열로 읽어오는 방법
    * Class.forName(“FQCN”)
    * 클래스패스에 해당 클래스가 없다면 ClassNotFoundException이 발생한다.
 
- Class<T>를 통해 할 수 있는 것
  * 필드 (목록) 가져오기
  * 메소드 (목록) 가져오기
  * 상위 클래스 가져오기
  * 인터페이스 (목록) 가져오기
  * 애노테이션 가져오기
  * 생성자 가져오기
  * ...
 

