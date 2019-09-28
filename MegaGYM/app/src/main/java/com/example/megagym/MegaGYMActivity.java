package com.example.megagym;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.ActionBarDrawerToggle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.core.view.GravityCompat;
        import androidx.drawerlayout.widget.DrawerLayout;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;

        import com.google.android.material.navigation.NavigationView;

public class MegaGYMActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_megagym);

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        //툴바에 버거아이콘 추가하기 위해서 객체 생성
        /**
         * new ActionBarDrawerToggle(
         * @param 1: 버거아이콘 붙일 객체 주소번지 - Activity
         * @param 2: drawerLayout - 스와핑시 나올 화면 배치
         * @param 3: 버거아이콘을 툴바에 붙임
         * @param 4: 열기에 사용할 문자상수
         * @param 5: 닫기에 사용할 문자상수
         *  )
         */
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this
                        ,drawerLayout
                        ,toolbar
                        ,R.string.nav_open_drawer
                        ,R.string.nav_close_drawer);
        /*드로워 토글을 생성한 다음 DrawerLayout에
        addDrawerListener메소드의 인자로 전달해서
        레이아웃에 추가하기*/
        drawerLayout.addDrawerListener(toggle);
        /*툴바의 아이콘과 드로워 상태를 동기하화는 메소드
        드로워를 열려고 아이콘을 클릭하면 아이콘이 바뀌어야 하니까*/
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        //사용자가 항목을 클릭하면 이를 통지 받을 수 있도록 네비게이션 뷰에 액티비티를 리스너로 등록함.
        navigationView.setNavigationItemSelectedListener(this);
        //프래그먼트 화면을 액티비티에 붙일 때 필요한 코드
        //프래그먼트 인스턴스화
        Fragment fragment = new LoginFragment();
        //프래그먼트 모듈화 - 재사용성(화면처리)
        //프래그먼트를 여러개 붙일 수 도 있다. -프래그먼트 매니저
        //프래그먼트 매니저의 도움으로 프래그먼트트랜잭션 객체를 로딩한다.( 메모리에 올린다. )
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame,fragment);
        ft.commit();
    }
    /*
    네비게이션 드로워의 아이템을 클릭하면 MegeGYMActivity가 응답할 수 있도록 액티비티에서
    NavigationView.OnNavigationItemSelectedListener를 구현
    그러면 사용자가 클릭할 때 마다 오버라이드한 onNavigationItemSelected가 호출.
    이 메소드가 호출되면 선택한 옵션에 따라 적절한 화면을 보여줌.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        Fragment fragment = null;
        Intent intent = null;
        switch(id){
            case R.id.nav_member:
                fragment = new MemberFragment();
                break;
            default:
                fragment = new LoginFragment();
        }//////////////end of switch
        //insert here
        //그래서 너 프래그먼트 화면이냐? - ft.commit()
        if(fragment != null){
            FragmentTransaction ft =
                    getSupportFragmentManager().beginTransaction();
            ft.add(R.id.content_frame,fragment);
            ft.commit();
        }
        //그래서 너 액티비티 냐? - startActivity(intent)
        else if(intent != null){
            startActivity(intent);
        }
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
