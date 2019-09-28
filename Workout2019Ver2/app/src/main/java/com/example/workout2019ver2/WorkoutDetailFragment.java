package com.example.workout2019ver2;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
/**
 * A simple {@link Fragment} subclass.
 * Fragment클래스는 Activity클래스를 상속받지 않음
 * Fragment는 Context 클래스를 구현하지 않습니다.
 * 액티비티와 달리 프래그먼트는 컨텍스트 유형이 아니므로 앱 환경 전역정보에 접근할 수 없습니다.
 * 대신 프래그먼트는 자신의 부모 액티비티 등 다른 객체의 컨텍스트를 이용해 이런 정보에 접근가능함.
 */
public class WorkoutDetailFragment extends Fragment {
    /*
        프래그먼트를 사용하는 액티비티가 있으면 액티비티는 어떤 방식으로든 프래그먼트와 의사소통을 해야됨.
        예를 들어 레코드를 자세히 표시하는 프래그먼트가 있다면 액티비티가 어떤 레코드를 자세히 표시할지
        프래그먼트에 알려줘야 됨.
        프래그먼트에 운동 ID값을 설정하는 단순한 setter메소드를 추가해야 됨.
        그러면 액티비티는 이 메소드로 운동ID를 설정함.
        나중엔 운동 ID를 이용해 프래그먼트 뷰를 갱신함.
         */
    private long workoutId;//운동 ID를 담을 변수
    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
    public WorkoutDetailFragment() {
        // Required empty public constructor
    }
    //
    //프래그먼트의 레이아웃이 필요할 때 안드로이드가 호출하는  onCreateView() 메소드를 구현합니다.
    //Activity의 경우 setContentView()메소드의 역할임
    //프래그먼트의 사용자 인터페이스를 가리키는 View객체를 반환함.
    /*
    LayoutInflater inflater인자:레이아웃을 인플레이트 하는데 사용함.
    레이아웃을 인플레이트하면 XML뷰를 자바객체로 변환합니다.
    두번째는 ViewGroup인자: 프래그먼트를 포함할 액티비티의 레이아웃을 가리킵니다.
    세번째 Bundle인자 : 프래그먼트의 상태를 저장했다가 다시 살려 낼때 사용
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //프래그먼트가 어떤 레이아웃을 사용하는지 안드로이드에 알려줘요.
        //fragment_workout_detail.xml
        //Container파라미터는 프래그먼트 레이아웃을 추가할 액티비티의 ViewGroup가리킨다.
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }
    //프래그먼트의 생명주기 콜백 메소드 중 onStart()오버라이드해야 됨.
    //프래그먼트가 보이는 상태가 되기 직전에 호출됨.
    public void onStart(){
        //생명주기 콜백메소드 구현시 반드시 상위 콜백메소드를 호출할것. -주의
        super.onStart();
        //getView()는 프래그먼트의 루트 뷰를 반환해줌.
        //이 뷰를 이용 운동제목과 설명을 텍스트뷰의 레퍼런스를 얻을 수 있음.
        View view = getView();
        if(view !=null){
            TextView tv_title = view.findViewById(R.id.textTitle);
            //선택한 운동제목에 대응하는 아이디 상수값에 해당하는 배열 접근하기
            Workout workout = Workout.workouts[(int)workoutId];
            tv_title.setText(workout.getName());
            TextView tv_description = view.findViewById(R.id.textDescription);
            tv_description.setText(workout.getDescription());
        }
    }///////////////end of onStart
}
