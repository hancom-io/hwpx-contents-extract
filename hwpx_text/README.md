# Hwpx Text
자바로 작성된 HWPX 파일의 데이터 추출 예제

## 소개 및 개발 환경 구성
### 소개
자바의 빌트인 라이브러리를 활용하여 HWPX파일를 압축 해제한 후 XML파일을 구문분석하여 데이터를 추출합니다.

### 개발 환경 구성
* Spring Tool Suite 4 (Version: 4.11.0.RELEASE, Build Id: 
202106180608)
* Jdk : 1.8.0 이상
* Server RunTime : Apache Tomcat V9.0
* Platform : Windows


## 사용 방법
- Spring Tool Suite 4를 이용하여 프로젝트를 불러오기 합니다. 
- Sample.java 파일의 main 메서드에서 hwpx의 실제 경로로 변경합니다. 
```java
      String filePath = "hwpx 전체 경로 설정";
```
- 추출된 텍스트/이미지 정보를 확인할 수 있습니다. 

## 소스코드 설명
- HwpxManager 클래스는 hwpx파일에 대한 핸들링을 위한 클래스입니다. 
- HwpxManager.Open 메소드를 통해 hwpx파일을 압축해제하여 텍스트 및 이미지 정보를 추출합니다. 
- HwpxManager.GetTextFile 메소드를 통해 인자가 0일 경우 텍스트를 문자열로 반환하고, 1일 경우 이미지 정보를 반환합니다.
- 텍스트의 경우 본문 영역의 텍스트에 한하여 추출하였습니다. 

## 라이선스
- Apache License Version 2.0



