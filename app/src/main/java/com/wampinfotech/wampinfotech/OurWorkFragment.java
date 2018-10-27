
package com.wampinfotech.wampinfotech;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.adapters.WorkCardAdapter;
import com.wampinfotech.wampinfotech.modals.TeamModal;

import java.util.ArrayList;

public class OurWorkFragment extends Fragment {

    ArrayList <TeamModal> ourWorks = new ArrayList <>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_our_work, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.nav_our_work);

        ourWorks.add(new TeamModal(getString(R.string.ow_wt_1), "https://lh3.googleusercontent.com/AM3mkPx9K3-09eRSjNsXpjwejCatiTHcgf9w4rEddSV9GVZLz3cMrBA_3tfrniQLSQ5QJuBrTlEjAVIGzbfJzbYdlVtnh9Yt9U5YoAF77tmkZ7PYJJrbUS2YxpTQmmTspsCkGVyNvPhe5wTB2cy97-zhVPIXbGctQFvUlAr6RXhb9U-yvs3yescqIPhDbL9yz6lpryLvHZAzTZEUcmBpXUQixVJXP2O1XWko4WBJNyL_G_xtHUoELV7jMMF78qvxrMZfi-QLusRgwdl0yfzx76XBkzT689SQ10b_qYdgvvTLnJuzuSJkDYkYG1ox5THuzJ27ItA2ikWaRpyfTigwlDGgtSVBTDyjDUEGgqN7vgHlT5GK_qfPJpYZR1j0JUCBlm3wKQQvytwE7AKMOp-NtJ1sd2NmMLyNOEs23EYrMq8ttbm0-hv31dP6sBhGTQ-Xtwkl4Q7nCZTsXxzYyEVNmce-fcu4UwlRLvKX9jFy1bBAnEzDbgEVqXqqHCGtjtZ7OddLVAAtNHQP1P9us7909qmAumgDFQ9migiS3cCITDVbXQkWvQHsExY-mrE2esYMo-wHk7qc27M3S8TVdAIHQRRnFt32xJFG=w640-h400-k", getString(R.string.ow_wurl_1)));
        ourWorks.add(new TeamModal(getString(R.string.ow_wt_2), "https://lh3.googleusercontent.com/8V5QXhjXZuzKhKXrnxSPjJAqjHWqM3s9g17zSypNbAwEuhACbRZfwge5Ut_q4gcKBPnglrJEfg1V6cTxrhEumtzv4sT92baeZf5KSkZEDNeTnS756pocWclHzoyKHyyaEgYfPgmIrp0cRCXAzTcfAvX3UoKDgD6F69WWt370fYEWoVl_SxSc7E8bZZY74hUkITuHtq_67Q-o3Fyk3im2CM8LpOs4qON95_Xh1Y2HX74OGJtsxfrFlbgNC9aKp6OaLH4DfbvQpV1VxUnTaH_bmzK27ELkX-6JZH3LSqoANmHqUxZFnQ1gEghw-SnMcQORnAx9ZeZDzrT0PGvVjUqjg0ZPsY6FV12kftGbWVaWRARsT81_CZOkLTzWAsjJ9syT1_GpbTIohhHZmVwQKYjF6g1zOuD56UwyKDI_HWRINygn9Pz9rvznU8XtTkj59KvC4QFKvC_Z-AwfdVCitPICvMbvhPlMr9jGzh02s3do48MVO0pQorhGi7FfokRlBaL2OUjorn4_rpY7CuAaMcZh35qW9_tiTCcIbnJMjjBxhuHAlLcu_c1Cy6o8KIj-MCy4cpi_drP39wtppHaaKnritCrrwAwfEkCK=w640-h400-k", getString(R.string.ow_wurl_2)));
        ourWorks.add(new TeamModal(getString(R.string.ow_wt_3), "https://lh3.googleusercontent.com/2DQFKJ_K9wsV3K6qYs8o-Uwno0X0pGZtnBPXA9s78OIllu_SY6O6PHOfQSC1lg-5ZGZDZpcDmeKHWfajIMJhfC1EdMQv7In5ar2oSKBzj0E-atYZ2HqJHVtCLa6eTVyp8UdV0ewNF2Fes_8l6KFln4b-jImBUFLMnWTHROgcC6g_l6zvJDFGRlGfJP6edkd1y0R_z4scdhMJWBSzu_UHtvvRr20PweRzBUz7ONUfhrwXYRo8lGP2iuGhnyJOVHPDS4d-YovGlZXndbhCIpErvbSHZiHOWtKjjypLXe8tWljINZi9ghU3xI6ldZvDAS4Cu6myL9l15w7lMO96AYCaDqP8C5wivLmE-dpXW4qZPedwSZ8jMFfYn7lgdVfBNaDhwEqX9gKromVmOahAAF_WmyV15DE2xF-3eVkDd2GiLVdkZeS42oBdSSL1BkIa2WxzGcRX_pEX15FUOrbkxwm4LZPgMFfxOU3abS9HUA68-LceHzJiJ4JJYoAdXwPWAzKIoRlMZKrGlvz0AIWnWoX2fZJH5zoVLStNe6MzYVdJI2RWuFGXJGPZeLHymA_q7ypUgyj8cOaP4IEmYM-ELrs29xVfWF1-1XB3=w640-h400-k", getString(R.string.ow_wurl_3)));

        ourWorks.add(new TeamModal(getString(R.string.ow_wt_4), "https://lh3.googleusercontent.com/8f9WcKrf5c4Kae9qaTTwQ3FMzV3KCsFzH48DnK8oo0BZ4qkXvT27-a0zpnKYMVTHeW-Pk6TkrkaeMkzwpY-nwYpzJLQ0etF75wQT9fib8P61VrznPsZ0ma4rVHjq7X9-H2hrRNVPg6J5M3qV4a-rDODmSKeVkUGs0ZdHKuwgR8DbtDLJHwHZ2EXBxvvP5uUTN1cb94RhRSyyMxX4LjrVkb4X7WVV_LO-0-EFRJ_sTOJC00ifhyvdsoAsKICb352WlgkJE_mfzwL8Gg4qF9a5C5kKkgadb6TIRCJfEwJUQcYpn0jjXM2pYgPitUwccRzwvHftr4IHz2ThOzRd85PXstXpy36_FXk_ge1t3Ep3Wz9aGMguu2Dj_fW5o1xh2VESs7F4PYS-Hd-3tNCBUyezXKSmvN4YkMJ73RuUt2pedhUqClFvkGgrIqBlZ1fV6fSEpaX8tomPJ6EZGhcvd-yIvOHettzXdznm-bgHUVslhfBVAQCJm5vzysX5e9_vVQXNKGMFRdg-Yr3Nu2eISllp2e5RFMQmMI7A0W-ErOLUNy7V_LY8fIXDvHPKbvAdR94QH6aBnHzm3gRe9oGyULRiEuxMwrwI61Um=w640-h400-k", getString(R.string.ow_wurl_4)));
        ourWorks.add(new TeamModal(getString(R.string.ow_wt_5), "https://lh3.googleusercontent.com/4V6sHUJoF7CdhQ_YyxA44-1RFA5CXNVxoKh-6NUczI5xxgiVjd3YDOg58EKU97OhEWkKOGlzNlabYc6FsA2Z-TUn3UtU0vKatik1w_iPjDxD2zhtMvqHE2itw1kPmYCHzakzD70ejreEYU6AN6B8urlFn_xl_QobhMsMs9fJv6418dTVUr3SEUa5i9ifop2zYlMxj0ztBgpcfqkYAXrZL0cnq7BycjkomxYfwm61_omB3iHDKGMLMZbeBJ6fwnYK6iU1Lw6-glYnRSpB00GPr4NMrtSELRCLUNITQ5rTlLjtnrw3m4P5pEl7qUfn6KB8zbyrMeVFFb1JZnwiidJWgYIm34VvGSp3Z6z8ZJN0zYkrWiYEAMfIp1ZMZRIsm7F_IEiNwyo9h-LVTTyPDk1bL93okiYkqQRz-KejQ8op6Yp5O5WEBA7xElhM4nzYKgEyaZuFcf-r-ahWn7hzDpMrAds1n9DwdHaIfnyBD_F8L5WLu41hhVcRBJ02xcvCC2GMIcUaFf9stujm2jE0XvXw39PzAyUcl6PAOuJrlcX1r1aaguA3gy591Vn4PApa62q6-Ep1muWGFoAEE8Nc8hqsn9KAAXVxIFYn=w640-h400-k", getString(R.string.ow_wurl_5)));
        ourWorks.add(new TeamModal(getString(R.string.ow_wt_6), "https://lh3.googleusercontent.com/iPE11mnYjWvB3qNhjlJcLGnI158pH4tjGAXnXmPE_DhgreyMTIAFfqXI_S4HrTM69SHXaK6raO5PJUxKEzxA0bUazzPTyz0U-2rne1Hhb6P8J4zOeyvgO-_g6wKA6EeY7VfaXoytWLOZjwaRFq_mK2_oluJcy29GD4200SnT2F09d5709mt5bLp1Ho9leCpa-lRgKC6CTHzEMFgHX35XexSnkqWVAx5jQ1bI5UCYuWRpA7BLA-OdlOPrqx4f0gcLjPW7pn9TXMUpAgiGry04arkWQ7qnD9Xtfq4bnZ51jo-Xb8pERSuBYynXX-44_U-Zi__ql-ssrgR-hdaQi_Uayb0u8tpI_3CijY9KaneakTO1SSTE5nTvDYaQTmTVbjyfybb2xp_ZE7jAjAnIhkrLgcM_O6uSVtXC_KeBfjbJ7_ZAXPcRRQbcK8XsiN2n-k_37YmKPouMcDyxau6P2FoZzY8W1BNAzxvFLPi4Tt_D2b9L63uS1DODxOfZODaVrWGG7CYh9pbnCvTP6yYQRlB40ysdfnjt0eD218bm0ClJ_g_8vP7QZLmipzNipYQEEJIx3c_EA_NMnZbzZtP0sjLW8DZBvvfVkLKZ=w640-h400-k", getString(R.string.ow_wurl_6)));

        GridView mAppsGrid = getView().findViewById(R.id.work_grid);
//        mAppsGrid.setExpanded(true);
        mAppsGrid.setAdapter(new WorkCardAdapter(this.getContext(), ourWorks));
        mAppsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                String url = ((TextView) view.findViewById(R.id.ow_desc)).getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
            }
        });
    }

}