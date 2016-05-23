# SharedPreferences

* 안드로이드에서 저장소에 데이터를 저장할 수 있는 방법에는 여러가지가 있는데, 이번시간에는 SharedPreferences에 대해 배워 보도록 하겠습니다.
* SharedPreferences는 내부 저장소에 [key, value] 형태의 파일로 저장하게 됩니다.
* 가장 접근 속도가 빠르나 많은 데이터를 효율적으로 관리하기에는 적합하지 않아 기본적인 설정값이나 유저 정보, 세션 정보를 저장하는데 주로 쓰입니다.

# 초기화
```java
// 전역으로 선언
SharedPreferences pref;
SharedPreferences.Editor editor;

// in OnCreate
/*
접근 범위에는 MODE_PRIVATE, MOVDE_WORLD_READABLE, MODE_WORLD_WRITEABLE 이 들어갈 수 있는데, 보통은 MODE_PRIVATE를 사용하며 나머지 두 권한은 다른 어플리케이션에서도 이 파일에 접근을 허용할지 결정하는 권한입니다.
 */
sharedPreferences = getSharedPreferences("파일명", 접근_범위);
editor = sharedPreferences.edit();
```

# 데이터 저장하기
데이터 저장에는 SharedPreferences.Editor 객체가 사용됩니다.
[키, 데이터] 형식으로 저장하는데, 데이터를 불러올떄 키로 불러오게 되므로 데이터당 키를 잘 지정해 주어야 합니다. 

```java
// String, int, boolean, Long, float 등 저장 가능
String s = editor.putString("키값", "데이터");
int a = editor.putInt("키값", 데이터);
boolean b = editor.putBoolean("키값", 데이터);
long l = editor.putLong("키값", "데이터");

// 작업 후에는 반드시 커밋
editor.commit();
```
이러면 저장이 완료됩니다.

# 데이터 불러오기
데이터 불러오기에는 SharedPreferences 객체가 사용됩니다.
[키, 만약 키에 해당하는 데이터가 없을 시 대체될 기본값] 형식으로 사용하며, 만약 SharedPreferences에 키에 해당하는 값이 없다면 Default값으로 반환됩니다.
사용할 수 있는 데이터 형식은 저장할 때와 동일합니다.
저장할 때와는 달리 따로 .commit()을 호출해줄 필요는 없습니다.

```java
String s = pref.getString("키값", "Default값");
int a = pref.getInt("키값", "Default값");
boolean b = pref.getBoolean("키값", "Default값");
```

# 유용한 메소드
```java
editor.remove("key"); // 키에 해당하는 데이터를 삭제합니다.
editor.clear(); // 저장된 모든 데이터를 삭제합니다.
boolean b = sharedPreferences.getAll().containsKey("key"); // 해당 key로 저장된 데이터가 존재하는지 boolean으로 반환합니다.
boolean c = sharedPreferences.getAll().containsValue("value"); // 해당 value로 저장된 데이터가 존재하는지 boolean으로 반환합니다.
boolean isEmpty = sharedPreferences.getAll().isEmpty(); // 완전히 비었는지 boolean으로 반환합니다.
```

