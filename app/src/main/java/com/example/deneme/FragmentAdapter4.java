package com.example.deneme;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter4 extends FragmentStateAdapter {
    public FragmentAdapter4(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1:
                return new PayPozisyon();
            case 2:
                return new PayBakiye();
            case 3:
                return new PortfoyViop();
            case 4:
                return new PortfoyViop();
            case 5:
                return new PortfoyViop();
        }
        return new EmirPay();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
