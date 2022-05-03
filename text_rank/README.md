# Text Rank
파이썬으로 작성된 텍스트 사용 빈도 추출 예제

## 소개 및 개발 환경 구성
### 소개
파이썬(3.x) 패키지를 활용하여 텍스트 파일을 입력 받아 파일 내 가장 많이 사용된 단어를 추출합니다.

### 개발 환경 구성
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

## 사용 방법
- 텍스트 파일을 입력받아 많이 사용된 단어를 추출하여 파일로 저장합니다.
- 사용된 단어 결과를 활용할 수 있습니다. 

```bash
$ python3 text_rank.py "입력.txt" "이미지 경로" "사용된 단어 결과.txt" "추출을 위한 단어 수"
```

## 소스코드 설명
- 파이썬을 활용한 텍스트 마이닝의 기본적인 예제 활용입니다. 
- HWPX에 대한 추출된 텍스트 파일을 입력받아 가장 많이 사용된 키워드를 추출하게 됩니다. 
- 완료된 키워드에 대한 정보를 텍스트 파일로 만드는 예제입니다. 
- 키워드 카운트에 대한 정보를 활용하여 시각화에 활용할 수 있습니다. 

## 라이선스
- Apache License Version 2.0

