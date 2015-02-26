# Android Badge
Android에서도 iPhone에서 나오는 것처럼 Badge를 사용할 수 있다.
이 내용은 [marojun님의 medium](https://medium.com/marojuns-android/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%84%EC%9D%B4%EC%BD%98-%EB%B1%83%EC%A7%80-%EC%99%84%EC%A0%84%EB%B6%84%ED%95%B4-c27028014e4d) 의 내용을 적용한 것임을 밝힌다.

![android badge example](./img/screen_shot.png);

## 적용 코드
```
// 참고에 있는 Medium에서 발췌한 코드로 Type1에 해당
Intent intent = new Intent(“android.intent.action.BADGE_COUNT_UPDATE”);

// 해당 App의 Package Name
intent.putExtra(“badge_count_package_name”, getComponentName().getPackageName());

// 해당 App의 Category.LAUNCHER에 해당하는 Class Name
// Class name은 full path가 포함 된 것으로. PackageName + ClassName 이다.
intent.putExtra(“badge_count_class_name”, getComponentName().getClassName());

// Badge count로 int형. 0이거나 int가 아닌 값이 들어간다면 사라진다.(갤럭시 그랜드 기준)
intent.putExtra(“badge_count”, count); sendBroadcast(intent);
```

## issue
1. Badge count는 런처에서 관리한다. 그래서 앱을 지웠다 켰을 때 그대로 남아있는 경우가 있다. 이를 해결하기 위해서 첫 구동시 badge_count를 0으로 설정해서 intent를 날려준다.
2. 홈 어플리케이션과 숏컷이 있는데 숏컷의 경우 badge_count를 업데이트 하지 않는다. 이 부분을 감안해서 서비스 해야 함.

# 참고
marojun's medium

https://medium.com/marojuns-android/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%84%EC%9D%B4%EC%BD%98-%EB%B1%83%EC%A7%80-%EC%99%84%EC%A0%84%EB%B6%84%ED%95%B4-c27028014e4d