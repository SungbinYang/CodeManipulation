# 리플렉션 API: 클래스 정보 수정 또는 실행

## Class 인스턴스 만들기
- Class.newInstance()는 deprecated 됐으며 이제부터는
- 생성자를 통해서 만들어야 한다.

## 생성자로 인스턴스 만들기
- Constructor.newInstance(params)

## 필드 값 접근하기/설정하기
- 특정 인스턴스가 가지고 있는 값을 가져오는 것이기 때문에 인스턴스가 필요하다.
- Field.get(object)
- Filed.set(object, value)
- Static 필드를 가져올 때는 object가 없어도 되니까 null을 넘기면 된다.

## 메소드 실행하기
- Object Method.invoke(object, params)
