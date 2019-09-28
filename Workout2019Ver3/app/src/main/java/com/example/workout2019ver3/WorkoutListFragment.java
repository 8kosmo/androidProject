package com.example.workout2019ver3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;

import com.example.workout2019ver3.Workout;

/*
프래그먼트의 생명 주기
onAttache() - onCreate() - onCreateView() - onActivityCreated()
onStart() - onResume() - onPause() - onStop() - onDestroyView() - onDestroy() - onDetach()
 */
public class WorkoutListFragment extends ListFragment {
    interface Listener{
        void itemClicked(long id);
    }
    private Listener listener = null;
    public WorkoutListFragment() {
        // Required empty public constructor
    }
    //두번째 리스너 등록하기
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        this.listener = (Listener)context;
    }
    //운동제목 클릭에 응답하기
    public void onListItemClick(ListView listView, View itemView, int position, long id){
        if(listener!=null){
            listener.itemClicked(id);
        }
    }
    //프래그먼트는 단독으로 화면처리하지 않는다.
    //왜? 프래그먼트는 단말기와 단독으로 소통이 불가하다.
    //ListFragment는 MainActivity의 부속페이지 입니다.
    //목록은 ListFragment에 있는데 화면처리는 MainActivity출력
    //실제 이벤트를 받는 클래스는 누구?
    //그럼 구현은 누가 해야되지?
    //부속페이지의 로딩 시점은 언제지?
    //프래그먼트 화면이 MainActivity에 출력되기 바로 직전에 메모리에 로딩해야 함.
    //메모리에 로딩해야함.
    //onAttache 콜백메소드 호출
    //위 메소드 안에서 초기화 처리 - Listener
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] names = new String[Workout.workouts.length];
        for(int i=0;i<names.length;i++){
            names[i] = Workout.workouts[i].getName();
        }
        //배열 어댑터를 생성해서 배열 어댑터를 리스트뷰 연결함.
        //Fragment는 Context의 하위 클래스가 아니다.
        //this로 현재 컨텍스트를 배열 어댑터에 전달할 수 없다.
        //LayoutInflater의 getContext()로 컨텍스트 얻을 수 있다.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(inflater.getContext()
                        , android.R.layout.simple_list_item_1
                        , names);
        //배열 어댑터를 리스트 뷰에 연결해요.
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }
}
