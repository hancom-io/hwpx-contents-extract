"""
 * Copyright 2022 Hancom Inc. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 """

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import requests
from bs4 import BeautifulSoup
import re
from konlpy.tag import Kkma 
from re import match
from collections import Counter
import random
import pytagcloud
import webbrowser

from konlpy.tag import Okt
import sys

def text_cleaning(text):
    hangul = re.compile('[^ ㄱ-|가-힣]+')
    result = hangul.sub('', text)
    return result

strTxtPath = sys.argv[1]
strImgFile = sys.argv[2]
strRankFile = sys.argv[3]
cntKeyword = int(sys.argv[4])

kkma = Kkma() 

file = open(strTxtPath, mode='r', encoding='utf-8')
doc = file.read()
file.close()

print('-------------------------')
nouns_target = Okt()
nouns2 = nouns_target.nouns(doc)
count2 = Counter(nouns2)

remove_char_counter = Counter({x:count2[x] for x in count2 if len(x) > 1})
print("char_counter = {}".format(remove_char_counter))

print('-------------------------')
ranked_tags = remove_char_counter.most_common(cntKeyword)

taglist = pytagcloud.make_tags(ranked_tags, maxsize=80)

wrfile = open(strRankFile, 'w')
vstr = ''
nRank = 1

for a in ranked_tags:
    vstr = vstr + str(nRank) + '. ' + str(a) + '\n'
    nRank += 1

vstr = vstr.rstrip('\n')
wrfile.writelines(vstr)
wrfile.close()

