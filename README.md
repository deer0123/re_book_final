# 최종 ReBook(중간 Book4W) 도서 리뷰 웹사이트 프로젝트
<img width="1237" alt="홈페이지" src="https://github.com/user-attachments/assets/0067ea4d-6d0c-4779-b82e-9c13501e7974">

## 1. 서비스 개요

우리 프로젝트는 **도서 리뷰 웹사이트**를 개발하여 독자들이 도서를 더 쉽게 발견하고, 리뷰를 통해 다른 사용자들과 소통할 수 있는 공간을 제공합니다. 도서와 회원 간의 상호작용을 강화하고 독서 경험을 더욱 풍부하게 만드는 효과를 기대할 수 있습니다. 독서를 즐기는 모든 연령대의 독서 애호가들에게 유용한 서비스가 될 것입니다.

### 1.1. 도서 리뷰, 평점, 좋아요 기능을 기반한 도서 추천 및 조회

독자들은 책을 읽은 후 자신의 리뷰와 평점 그리고 좋아요를 공유하고, 다른 사람들이 남긴 리뷰를 통해 책을 선택할 때 도움을 얻을 수 있습니다. 이것은 독서 커뮤니티를 더욱 활성화시키는 핵심적인 요소입니다. 실제 독자들의 리뷰를 기반으로 신뢰할 수 있는 정보를 얻을 수 있으므로 실패하지 않는 선택을 경험할 것입니다.

### 1.2. 회원제로 나의 기록과 프로필 관리

회원이 남긴 리뷰, 평점, 좋아요를 회원 고유번호로 관리하여, 자신이 남긴 기록을 직관적으로 조회할 수 있습니다. 이를 통해 사용자는 자신의 독서 기록을 쉽게 관리하고, 즐겨읽은 도서를 다시 찾는 데 도움을 받을 수 있습니다.

---
## 2. 개발 이력
### 2.1. 개발 기간: 2024-12-05 ~ 2024-12-09 (최종), 2024-10-21 ~ 2024-10-30 (중간)
### 2.2. 팀원
- 박성찬(PM, Back-End), 김원(Back-End), 배승준(Front-End), 김성철(Back-End)
### 2.3. 기술 스택
#### 2.3.1. 최종
- <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=REACT&logoColor=white">
- <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white">
- <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/redis-FF4438?style=for-the-badge&logo=redis&logoColor=blue">
- <img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
- <img src="https://img.shields.io/badge/amazonec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"> <img src="https://img.shields.io/badge/amazons3-569A31?style=for-the-badge&logo=amazons3&logoColor=white"> <img src="https://img.shields.io/badge/amazonrds-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white">
- <img src="https://img.shields.io/badge/githubactions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white">
- <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/notion-00148C?style=for-the-badge&logo=notion&logoColor=white">

#### 2.3.2. 중간
- <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">
- <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white">
- <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white">
- <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/notion-00148C?style=for-the-badge&logo=notion&logoColor=white">

---
## 3. 주요 기능별 논리 구조
### 3.1. 도서 리뷰, 평점, 좋아요 기능을 기반한 도서 추천 및 조회
#### 3.1.1. 도서 추천
- 리뷰 수, 평점 수, 좋아요 수를 기준으로 기준값이 높은 도서 중 3개를 각각 골라 추천도서로 제시합니다.
- 각 기준별 화면은 일정시간이 지나면 슬라이드 효과로 자동 전환됩니다.
- 사용자가 화살표 클릭으로 화면을 수동 전환을 할 수 있습니다.
- 해당 카드를 선택하여 상세정보를 확인합니다.
  
##### 최종
![1](https://github.com/user-attachments/assets/18f55ee6-7c1a-4191-95c2-3939152fb735)

##### 중간
![홈화면](https://github.com/user-attachments/assets/ebdfb0a5-6483-4f9c-8e79-114f5339e9fc)

#### 3.1.2. 도서 목록 조회
- 한 페이지에 9개 카드 목록을 제시하고, 도서의 주요 정보를 카드에 표시합니다.
- '좋아요 수', '리뷰 수', '평점 수' 순으로 카드 목록을 정렬합니다.
- 페이징 기능을 제공합니다.
- 검색어를 입력하여 도서를 검색합니다.
- 해당 카드를 선택하여 상세정보를 확인합니다.

##### 최종
![2](https://github.com/user-attachments/assets/7b50c674-a8d9-4620-acc8-d7291097b31c)

##### 중간
![도서목록](https://github.com/user-attachments/assets/b9b23f40-82c1-4365-9fef-1c5666c5ef73)


#### 3.1.3. 도서 상세정보 & 리뷰, 평점, 좋아요 입력
- 도서의 주요 정보 그리고 회원이 입력한 리뷰와 평점을 표시합니다.
- 회원은 좋아요, 리뷰, 평점을 입력할 수 있고, 입력한 내용을 수정 또는 삭제할 수 있습니다.
- 비회원은 입력할 수 없고, 로그인을 하도록 요청합니다.

##### 최종
![3](https://github.com/user-attachments/assets/55ddf5d3-60d1-44eb-afc6-118ec78a7188)

##### 중간
![상세정보](https://github.com/user-attachments/assets/04c3bbdf-cd70-4b84-b4c5-4f466680296d)

### 3.2. 회원제로 나의 기록과 프로필 관리
#### 3.2.1 로그인 & 로그아웃
- 이메일과 비밀번호를 입력하여 로그인합니다.
- 세션을 활용하여 로그인 상태를 유지합니다.
- 로그아웃 버튼을 클릭하여 로그아웃합니다.

#### 3.2.2. 회원가입 & 이메일 인증
- 이메일을 입력하고 이메일 인증을 요청하면 인증 코드를 해당 이메일로 발송하고 인증 코드 입력을 활성화합니다.
- '이메일', '인증 코드', '닉네임', '비밀번호', '비밀번호 확인'의 입력 유효성이 확인되면 회원가입 버튼을 활성화합니다.

#### 3.2.3 프로필 조회 & 수정
- '닉네임', '이메일', '가입 날짜'를 표시합니다.
- 새로운 닉네임을 입력하여 수정합니다.

#### 3.2.4. 나의 좋아요 & 나의 리뷰 조회
- 회원이 작성한 '리뷰', '평점', '좋아요' 기록을 목록으로 확인합니다.
- 해당 책을 선택하여 상세정보를 확인합니다.

##### 최종
![5](https://github.com/user-attachments/assets/e9a0db2b-5e45-4872-a303-bcb935e509e9)

##### 중간
![나의 리뷰 좋아요](https://github.com/user-attachments/assets/7f97dd98-91bb-419a-bc6d-427f78fe6ea3)

#### 3.2.5. 사용자 권한 부여
- 비회원은 '나의 리뷰', '나의 좋아요', 나의 프로필'에 접근할 수 없습니다.
- 회원은 '로그인', '회원가입'에 접근할 수 없습니다.

---
## 4. 배포ㆍ자동화
- Front-End : Github Actions에서 빌드 후 AWS S3에 배포한다.
- Back-End : Github Actions에서 빌드 후 Docker 이미지를 Docker Hub에 보내고, Dokcer Hub로부터 Docker 이미지를 AWS EC2에 가져와서 배포한다.

---
## 5. 데이터베이스 ERD
![image](https://github.com/user-attachments/assets/6f9790c8-71e6-4103-b19c-35d1852f798d)

---
## 6. WBS
##### 최종
![wbs](https://github.com/user-attachments/assets/d86999e2-45bf-4856-94cc-8a04a657ec78)

##### 중간
<img width="1035" alt="WBS" src="https://github.com/user-attachments/assets/f67c4ec9-6073-4452-b313-d6ec43ebe8e9">

---
## 7. API
<img width="935" alt="API 명세서 1" src="https://github.com/user-attachments/assets/5b9ae5c9-9ed5-475e-8c15-30c9ff9147a4">
<img width="936" alt="API 명세서 2" src="https://github.com/user-attachments/assets/9ba2f0af-4b58-4582-8c0d-5a62712adf77">
<img width="937" alt="API 명세서 3" src="https://github.com/user-attachments/assets/f08b4a12-1aa1-4bd0-a8e0-fe9b8205e0c2">
<img width="937" alt="API 명세서 4" src="https://github.com/user-attachments/assets/618ec477-3e3c-4e0a-8a56-4646e1b1c760">

--
## 8. 최종ㆍ중간 회고
### 8.1. 박성찬
>#### 8.1.1. 최종
>- 본 프로젝트에서 저는 JSP에서 React로의 프레임워크 전환을 성공적으로 수행하며, React의 핵심 아키텍처와 구현 방법론을 체계적으로 습득하였습니다. REST 아키텍처 기반의 컨트롤러를 구현하는 과정에서 서버-클라이언트 간 데이터 통신 프로토콜과 프론트엔드 데이터 처리 로직에 대한 전문적 이해를 도모하였습니다. 이전 팀 프로젝트 경험을 기반으로 본 프로젝트의 기술적 과제들을 전략적으로 해결하였으며, 이를 통해 개발 역량과 문제 해결 능력이 현저히 향상되었습니다.

>#### 8.1.2. 중간
>#### 8.1.2.1. 프로젝트에 앞서 마음가짐
>- 협업 경험에 집중하기, 기능 구현은 부차적으로
>- 조장으로서 기획, 설계, 역할 분담, 업무 분배 등 전체 프로세스 파악하기
>- 수업 시간에 배운 내용을 실제로 적용하고 내재화하기
>- 2주일도 안되는 프로젝트 기간인 만큼, 프로젝트 자체의 규모나 기술 보다 협업 하는 과정에서 협업 도구, 프로젝트 설계 및 기획, 의견 조율 등에 집중하여 코드 외 적으로 어떻게 팀원들과 프로젝트를 이끌어나가야하는지에 대해 집중했다.
>#### 8.1.2.2. 프로젝트를 시작하며
>- 조가 정해지고 처음으로 회의를 했다. "조장을 뽑지 않아도 되지 않을까?"라는 의견이 오갔다. 나는 협업에 있어 각자 분명한 책임과 역할을 지고 성실하게 프로젝트에 임하려면 조장이 꼭 필요하다고 생각했다. 그리고 나는 조장이 되었다. 조장을 꼭 해야겠다고는 생각하지 않았다. 생각할 게 너무 많았기 때문이다. 하지만 팀원들이 잘 따라와 줘서 그런지, 조장으로서 업무 분담을 위해 의견을 조율할 때 크게 에너지가 들지 않았다.
>#### 8.1.2.3. 의견조율
>- 프로젝트를 진행하며 팀원들의 컨디션을 고려하여 새로운 아이디어를 제시할 때는 항상 정당성을 부여했고, 모두가 납득할 수 있을 때에만 채택했다. 특히, 이러한 과정을 통해 필요한 정보 탐색에 걸리는 시간을 줄이고, 스스로 부족한 점을 파악하는 능력을 키울 수 있었다. 이는 당면한 문제를 해결하기 위한 중요한 발판이 되었다.
>#### 8.1.2.4. 트러블슈팅
>- 프로젝트를 진행하며 다양한 문제 상황에 직면했다. 특히 데이터베이스와 웹 간의 데이터 교환 구조를 제대로 파악하지 못해 해결에 큰 어려움을 겪었다. 다행히 수업에서 실습했던 프로젝트 내용과 GPT에서 생성된 예시들이 이해를 돕는 데 큰 도움이 되었다. 결국, 깊이 이해하지 못한 기술이라면 문제에 부딪혀가며 경험하고, 그 과정에서 얻은 지식을 내 것으로 만드는 것이 중요하다는 걸 깨달았다.
>#### 8.1.2.5. 프로젝트를 마무리하며
>- 짧은 기간의 프로젝트임에도 불구하고 처음 경험하는 프로젝트인 만큼, 프로젝트 진행에 있어 역할 분담의 중요성을 깨달았다. 일일 계획, 주간 계획 등 주어진 일정에 적절한 업무를 할당하여 계획대로 진행하는 것이 체계적인 장점과 함께 정신적 안정감을 제공한다는 사실을 깨달았다.
>#### 8.1.2.6. 프로젝트 전체 리뷰
>- 첫 프로젝트의 첫 조장 역할로서 프로젝트를 기획하고 설계하며, 팀원들과 의견을 조율하고 역할을 분담하는 과정에서 조장으로서의 책임감을 깊이 느꼈다. 완벽하지 않은 조장을 믿고 따라와 준 조원들에게 큰 고마움을 느낀다. 덕분에 프로젝트가 예상 범위 내에서 잘 마무리되어, 조장으로서의 역할을 적절히 수행한 것 같다.

### 8.2. 김원
>#### 8.2.1. 최종
>- 이번 배포 단위 프로젝트에서는 JSP를 React로 전환하고, 프론트엔드 배포 작업을 맡아 수행하였습니다. React로의 전환뿐만 아니라, S3 버킷을 활용하여 배포 자동화를 진행하며, 새로운 기술 환경에 적응하는 경험을 쌓을 수 있었습니다. 이전 프로젝트에서는 비동기 요청이 간헐적으로 성공하거나 실패하는 문제가 있었습니다. 이번 프로젝트에서는 해당 문제를 해결하기 위해 코드를 하나씩 세심하게 점검하고 수정하였습니다. 이 과정에서 비동기 처리의 안정성을 높이는 데 성공했으며, 구현 단계에서의 꼼꼼한 점검과 디버깅의 중요성을 다시 한번 실감하였습니다.
>- 다만, 프로젝트 진행 중 프론트엔드와 백엔드 간 변수명 통일성 부족으로 인해 데이터 송수신 과정에서 예기치 못한 문제들이 발생하였습니다. 프론트엔드와 백엔드에서 사용하는 변수명이 서로 달랐기 때문에 데이터 처리 로직에 혼선이 생겼고, 이를 해결하는 데 적지 않은 시간이 소요되었습니다. 이러한 경험을 통해 기획 단계에서 변수명에 대한 명확한 약속과 정리가 필수적이라는 점을 절실히 깨달았습니다. 또한, 기획 단계에서의 세부적인 논의가 프로젝트 전체의 효율성과 정확성을 높이는 데 얼마나 중요한지를 다시 한번 확인할 수 있었습니다.
>- 프론트엔드 배포 과정에서는 S3 버킷을 활용한 자동화 작업을 진행하였으나, 빌드 처리 순서를 명확히 정하지 않은 문제로 인해 많은 시간을 소비하게 되었습니다. 이 과정에서 배포 자동화의 성공 여부는 작업 순서와 전체 과정에 대한 정확한 이해와 숙지에 달려 있음을 깨달았습니다. 빌드와 배포의 세부적인 작업 순서를 문서화하고, 이를 기반으로 자동화 프로세스를 설계해야 한다는 교훈을 얻을 수 있었습니다.
>- 팀 프로젝트를 진행하면서 제 실력에 대한 걱정도 있었지만, 프로젝트를 통해 그동안 배우고 쌓아왔던 흩어진 지식들이 하나로 정리되고 체계화되는 것을 느낄 수 있었습니다. 또한, 팀원들과의 협업 과정에서 효과적인 소통과 협업의 중요성을 배울 수 있었습니다. 협업은 단순히 각자의 역할을 수행하는 것을 넘어, 팀원들과의 적극적인 소통과 의견 조율을 통해 프로젝트를 성공적으로 완성하는 데 핵심적인 역할을 한다는 점을 다시금 깨닫는 계기가 되었습니다.

>#### 8.2.2. 중간
>##### 8.2.2.1. 프로젝트 개요 및 목표 설정
>- 이번 프로젝트는 단위 과제로 도서 리뷰 시스템을 개발하는 것을 목표로 진행되었습니다. 프로젝트 기간이 짧고, 팀원 모두가 학습 단계에 있는 점을 고려하여 기능 구현보다는 배운 내용을 실질적으로 활용해보는 데 중점을 두었습니다. 이를 통해 프로젝트 결과물의 완성도를 높이는 것을 목표로 삼아 진행하게 되었습니다.
>##### 8.2.2.2. 담당 역할 및 주요 구현 사항
>- 제가 주로 맡은 부분은 리뷰 시스템과 홈 화면 추천 기능이었습니다. 이 과정에서 리뷰의 CRUD 기능, 평점 관리, 추천 항목별 데이터 필터링 기능을 구현했으며, 리뷰 데이터를 모델에 전달하여 JSP에서 출력할 수 있도록 설계하였습니다. 이를 통해 사용자들이 리뷰를 조회, 작성, 수정, 삭제할 수 있는 시스템의 주요 기능을 충실히 구현할 수 있었습니다.
>##### 8.2.2.3. 프로젝트 진행 중 어려움 및 개선 방향
>- 짧은 프로젝트 기간 동안 필수 기능을 우선순위에 두고 빠르게 진행하느라 각 기능을 깊이 있게 다루지 못한 점이 아쉬웠습니다. 향후 프로젝트에서는 시간 관리와 역할 분배를 더욱 체계적으로 할 수 있는 방법을 모색하고자 합니다.
>- 또한, JSP와 JavaScript, Java에서의 데이터 처리 방식 차이를 이해하는 데 시간이 필요했습니다. 특히, EL 표현식 사용과 비동기 데이터 처리 과정에서 발생하는 문제를 해결하는 데 어려움을 겪었습니다. 다음 프로젝트에서는 프론트엔드와 백엔드 간의 데이터 흐름을 더 깊이 이해하고, JSON 형식을 활용해 데이터 전달의 효율성을 높이는 데 중점을 두고자 합니다.
>##### 8.2.2.4. 협업 과정에서의 경험과 교훈
>- GitHub를 통한 협업 과정에서 예상치 못한 문제들이 발생해 해결하는 데 많은 시간이 소요되었습니다. 이 과정에서 팀원들과의 소통 및 GitHub 사용에 더욱 익숙해져야 함을 느꼈습니다. 또한, 초기 기획이 부족하여 프로젝트 진행 중 팀원들과 지속적으로 확인해야 했고, 이로 인해 불필요한 소통이 발생하였습니다. 이러한 경험을 바탕으로 앞으로는 기획 단계를 더욱 철저히 하고, 프로젝트 진행 과정에서 발생할 수 있는 문제를 미리 대비하고자 합니다.
>##### 8.2.2.5. 개인적인 성찰 및 향후 학습 목표
>- 프로젝트를 마치고 나니 제가 사용하는 언어나 프레임워크에 대한 지식을 더 깊이 다져야겠다는 생각을 하게 되었습니다. 더불어, 백엔드 개발자로서 백엔드뿐만 아니라 전체적인 개발 흐름을 이해하기 위해 프론트엔드와 UI/UX에 대한 이해를 높이는 것이 중요하다는 것을 깨달았습니다. 앞으로는 기술적인 깊이를 더하는 동시에 전반적인 개발 프로세스를 파악하는 데에도 집중할 계획입니다.

### 8.3. 배승준
>#### 8.3.1. 최종
>##### 8.3.1.1. 프로젝트 과정에서의 역할과 기여
>- 이번 프로젝트에서는 기존의 JSP 기반 웹 애플리케이션을 리액트로 전면 리팩터링하여 성능과 유지 보수성을 개선했습니다. 주요 작업은 컴포넌트 설계와 상태 관리 최적화, CSS 모듈화를 통한 스타일링 정리였습니다.
>- 배포는 AWS S3를 활용해 정적 파일을 업로드하고, S3 버킷을 통한 안정적인 웹 애플리케이션 배포를 완료했습니다. 이를 통해 사용자가 손쉽게 웹 애플리케이션에 접근할 수 있도록 안정성과 효율성을 보장했습니다.
>
>##### 8.3.1.2. 매일의 진전과 성장
>- 리액트 리팩터링 과정에서 초반에는 컴포넌트 설계 및 상태 관리 방식에 적응하는 데 어려움을 겪었지만, 점진적으로 사용자가 재사용 가능한 UI 컴포넌트를 설계하며 생산성을 향상시켰습니다.
>- 특히, useState와 useEffect를 적절히 사용하여 사용자 인터페이스를 동적으로 처리하고, 기존의 명령형 방식에서 선언형 방식으로 전환함으로써 코드의 가독성과 유지 보수성을 크게 향상시켰습니다.
>- 배포 과정에서는 AWS S3의 설정과 파일 업로드 자동화에 대해 학습하며, 실제 배포 환경을 경험했습니다. 이를 통해 기술적 이해와 실무 능력을 강화할 수 있었습니다.
>
>##### 8.3.1.3. 힘들었던 점과 극복
>- 리액트 전환 초기에는 기존 JSP 방식과 리액트의 선언적 방식의 차이를 극복하는 데 시간이 필요했습니다. 특히, 상태 관리에서의 비효율성을 발견하고 개선하는 과정에서 여러 시행착오를 겪었습니다.
>- 또한, AWS S3 배포 시 권한 설정 및 캐싱 관련 문제로 인한 예상치 못한 에러가 발생했으나, AWS 공식 문서와 커뮤니티 자료를 참고하며 문제를 해결했습니다. 이러한 과정을 통해 디버깅과 배포에 대한 자신감을 얻었습니다.
>
>##### 8.3.1.4. 향후 계획과 다짐
>- 이번 프로젝트를 통해 리액트와 배포 환경에 대한 깊은 이해를 얻을 수 있었으며, 이를 기반으로 다음과 같은 계획을 세웠습니다:
>- 배포 자동화: CI/CD 도구 (예: GitHub Actions)를 사용해 배포 자동화 구축.
>- 이번 리팩터링과 배포는 단순히 기술을 익히는 것을 넘어 실무적인 문제 해결 능력을 키우는 데 큰 도움이 되었습니다. 앞으로 더 많은 도전을 통해 개발자로서 꾸준히 성장하겠습니다.

>#### 8.3.2. 중간
>##### 8.3.2.1. 프로젝트 과정에서의 역할과 기여  
>- 이번 프로젝트에서 주로 홈페이지와 관련된 레이아웃과 디자인을 책임지셨으며, 각 도메인별 CSS와 JSP 파일 제작, 컨트롤러 연결 및 테스트를 수행하였습니다. 특히, 프로젝트 초기에는 별점 매기기 메서드를 적극적으로 활용하여 기능 확장에 기여했습니다. 이 외에도 메인 페이지와 보드 조회, 페이징, JSP 연결을 마무리함으로써 기본 구조 완성에 큰 역할을 했습니다.
>##### 8.3.2.2. 매일의 진전과 성장
>- 개발 과정의 어려움을 느꼈지만, 이내 꾸준히 노력한 결과 디자인 수정을 마치고 전체적인 웹페이지 레이아웃을 보완하며 한 걸음씩 성과를 쌓아나갔습니다. 또한, 멘탈 관리를 중요시 여기며 지속적인 자기 관리를 통해 점차 프로젝트의 전반적인 요구사항을 충족시켰습니다. 마지막에는 "열심히 하니 결과가 보인다"라는 생각이 들며 긍정적인 마무리를 지을 수 있었습니다​​​.
>##### 8.3.2.3. 힘들었던 점과 극복
>- 이번 프로젝트는 승준에게 끊임없이 새로운 과제를 제시하며 도전의 연속이었습니다. CSS와 JSP 파일 제작 및 컨트롤러 연결을 처음부터 학습하고 실습하면서, 기능을 제대로 구현하기까지 많은 어려움을 겪었습니다. 특히 개발자라면 누구나 겪는 성장통을 잘 이겨내며 차근차근 기능들을 완성해 나갔습니다.
>##### 8.3.2.4. 향후 계획과 다짐
>- 팀 프로젝트를 하다 보니 기능 구현에는 충분한 공부가 필요하다는 걸 느껴서 더 많은 시간을 투자해서 공부하겠습니다 그리고 유연함을 곁들여서 팀원의 공동의 목표에 갈 수 있게 끔 노력하겠습니다

### 8.4. 김성철
>#### 8.4.1. 최종
>- 최종 프로젝트는 중간 프로젝트 결과물를 기반으로 JSP를 React로 전환하고, AWS와 도커를 활용하여 배포하고 Github Actions를 통한 자동화를 하였다. 프로젝트의 전반적인 흐름을 경험하고 익히는 유익한 시간이었다.
>- 리액트 페이지를 만드는 과정에서 새로운 문법을 익히고 원하는 화면을 구현할 때까지 수정하는 과정을 거쳤다. 리액트에 대한 거부감을 줄이는 시간이 되었다.
>- 이메일 인증 과정 중 일부 로직을 백엔드에서 프런트엔드로 옮겼다. 백엔드에서만 로직을 구현해야 한다는 고정관념을 깨는 계기가 되었다.
>- 배포와 자동화를 위해 다양한 설정값을 선택하고 입력하면서 신중하게 접근하였으나 제대로 작동하지 않는 어려움이 있었다. 학습한 순서대로 진행했음에도 일부 실수가 있어 원인을 찾는데 시간을 소비하였다. 끈질기게 오류 정보를 확인하고 교육 자료를 기반으로 접근하니, 어느새 Push 한번으로 백엔드의 수정사항은 AWS EC2 서버에, 프런트엔드의 수정사항은 AWS S3에 전달되어 실행되었고, 정상적으로 작동하는 것을 보고 짜릿한 기쁨을 느꼈다. 이 같은 성공 경험은 AWS, 도커, 깃허브액션을 더 깊이 공부하고 싶은 욕구을 갖게 한다.
>- 프로젝트 과정에서 계획한 과제를 수행하지 못해 내적 갈등 또는 팀원과 외적 갈등이 있었으나, 어려운 시기를 넘기고 부족했던 부분을 다른 영역에서 만회하여 스스로 다행으로 여긴다. 더디지만 포기하지 않고 나아간 나 자신에게 칭찬하고, 인내하며 기다려주고 도와준 팀원들에게 고마움을 전한다.

>#### 8.4.2. 중간
>##### 8.4.2.1. 돌아보며
>- 로그인과 회원가입 영역을 담당하였지만 기능을 구현하기에는 실력이 미약하였다. 이론에 대한 숙지가 부족하였고, 부족함을 채울 해결 방법을 적시에 찾지 못하여 헤매는 시간이 많았으며, 맡은 기능을 구현하지 못하고 포기하는 경험을 하였다. 일의 진척이 더뎌 동료에게 일이 넘어가는 일이 마저 발생하였다. 당장 어떻게 할 수가 없으니 괴로운 일이었다.
>- 회원 Entity를 만들고 데이터베이스에 연동하는 일부터 쉬운일이 아니었다. 무엇을 모르는지 모르는 상태에서 적절한 질문조차 할 수 없었다. 스프링부트 등 편리한 도구들이 개발을 지원하고 있지만 여러 계층으로 따라 데이터가 오고가는 흐름과 그 실현은 혼란스러운 용어들과 함께 이해하기 어려운 일이었다. 방향을 찾기 시작한 것은 이메일 인증을 통한 회원가입 기능을 구현하면서부터다. 메일과 연동하는 설정을 순서대로 진행하고, 입력에서 데이터베이스까지 회원가입 논리를 구현하면서 가능성을 맛보았다. 비밀번호 찾기 기능도 그 연장에서 구현할 수 있을테지만 시간이 허락하지 않는다.
>- 정적 CSV 데이터를 데이터베이스에 자동으로 입력하는 일은 상대적으로 수월하였다. 처음 기획할 때 정적 DB를 고려해서 시작하자는 의견을 낸 입장에서 미리 머리속에서 그리고 있었던 일이었고 관련 정보를 쉽게 얻어 구현할 수 있었다.
>##### 8.4.2.2. 앞으로
>- 이번 프로젝트는 전체적인 흐름을 이해하고, 학습 동기를 느끼게 해주어 그 가치가 충분하다. 백엔드도 갈 길이 멀지만, 종종 프런트를 수정해야 하는 일을 마주했을 때 HTML과 자바스크립트에 대한 두려움으로 어쩌지 못하는 일이 있어 복습의 필요를 느꼈다. 그리고 동료들이 구현한 CRUD 게시판과 기타 기능들을 온전히 내 힘으로 구현하고 싶다. 시간이 허락하는 한 부족한 부분을 지속적으로 학습할 것이다.
