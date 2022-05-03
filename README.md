# Hwpx Contents Extract
HWPX 파일의 데이터를 추출(Hwpx Text)하고 텍스트 사용 빈도 추출(Text Rank) 예제

## 소개 및 개발 환경 구성
### Hwpx Text 소개
자바의 빌트인 라이브러리를 활용하여 HWPX파일를 압축 해제한 후 XML파일을 구문분석하여 데이터를 추출합니다.

### Hwpx Text 개발 환경 구성
* Spring Tool Suite 4 (Version: 4.11.0.RELEASE, Build Id: 
202106180608)
* Jdk : 1.8.0 이상
* Server RunTime : Apache Tomcat V9.0
* Platform : Windows 또는 Linux

### Hwpx Text 사용 방법
- Spring Tool Suite 4를 이용하여 프로젝트를 불러오기 합니다. 
- Sample.java 파일의 main 메서드에서 hwpx의 실제 경로로 변경합니다. 
```java
      filePath = "실제 hwpx 파일의 전체 경로";
```
- 추출된 텍스트/이미지 정보를 확인할 수 있습니다. 

### Hwpx Text 소스코드 설명
- HwpxManager 클래스는 hwpx파일에 대한 핸들링을 위한 클래스입니다. 
- HwpxManager.Open 메소드를 통해 hwpx파일을 압축해제하여 텍스트 및 이미지 정보를 추출합니다. 
- HwpxManager.GetTextFile 메소드를 통해 인자가 0일 경우 텍스트를 문자열로 반환하고, 1일 경우 이미지 정보를 반환합니다.
- 텍스트의 경우 본문 영역의 텍스트에 한하여 추출하였습니다. 



### Text Rank 소개
파이썬(3.x) 패키지를 활용하여 텍스트 파일을 입력 받아 파일 내 가장 많이 사용된 단어를 추출합니다.

### Text Rank 개발 환경 구성
* Python 버전 : 3.6.8 이상
* Platform : CentOS 7.9
* Package Install

```bash
$ yum install gcc-c++ java-1.8.0-openjdk-devel python3 python3-devel python3-pip make diffutils
$ pip3 install --upgrade pip
$ pip3 install pandas
$ pip3 install matplotlib
$ pip3 install requests
$ pip3 BeautifulSoup4
$ pip3 install konlpy
$ pip3 install pytagcloud
$ pip3 install pygame
$ pip3 install simplejson
```

### Text Rank 사용 방법
- 텍스트 파일을 입력받아 많이 사용된 단어를 추출하여 파일로 저장합니다.
- 사용된 단어 결과를 활용할 수 있습니다. 

```bash
$ python3 text_rank.py "입력.txt" "이미지 경로" "사용된 단어 결과.txt" "추출을 위한 단어 수"
```

### Text Rank 소스코드 설명
- 파이썬을 활용한 텍스트 마이닝의 기본적인 예제 활용입니다. 
- HWPX에 대한 추출된 텍스트 파일을 입력받아 가장 많이 사용된 키워드를 추출하게 됩니다. 
- 완료된 키워드에 대한 정보를 텍스트 파일로 만드는 예제입니다. 
- 키워드 카운트에 대한 정보를 활용하여 시각화에 활용할 수 있습니다. 

## 라이선스
- Apache License Version 2.0


