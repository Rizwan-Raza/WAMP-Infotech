package com.wampinfotech.wampinfotech.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.adapters.ServiceCardAdapter;
import com.wampinfotech.wampinfotech.adapters.TechCardAdapter;
import com.wampinfotech.wampinfotech.modals.ServiceCard;
import com.wampinfotech.wampinfotech.modals.TechModal;
import com.wampinfotech.wampinfotech.utils.ExGridView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList <TechModal> techs = new ArrayList <>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");

        // Create a list of words
        ArrayList <ServiceCard> homeServices = new ArrayList <>();
        homeServices.add(new ServiceCard(getString(R.string.h_s_c_1), R.drawable.ic_color_lens_black_24dp));
        homeServices.add(new ServiceCard(getString(R.string.h_s_c_2), R.drawable.ic_code_black_24dp));
        homeServices.add(new ServiceCard(getString(R.string.h_s_c_3), R.drawable.ic_shopping_cart_black_24dp));
        homeServices.add(new ServiceCard(getString(R.string.h_s_c_4), R.drawable.ic_desktop_windows_black_24dp));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        ServiceCardAdapter adapter = new ServiceCardAdapter(this.getContext(), homeServices);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        GridView listView = getView().findViewById(R.id.home_services_list);
        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        ///////////////////////////////////////////////////////////

        techs.add(new TechModal("HTML5", "https://lh3.googleusercontent.com/uJM70ILR139J4QHlkWANuDatafr2wqdEnMXwXfHjyfNWHmolSTfQFK28szvzDRbiUUMafHdxu3d3wayKyNAANedzjqDghIbC4lZwS3ocKNqq5EBeG7OMngqg6Q5HVs_TCGlwirT6IUmUL3BY3V0rxCgfG_5RaXeRXHDF6fB-0u-0Mdc1fhnHECVDvNVTgkChvYRDQl1aek5KF56FoUhKcC3gR-oXt9fVDLmTvz8HtKddV9PgnoCveo09x9lT8Qw2-znOMlQa1v5aeTNiaj3anJ6WdBAgg2qrrOvQ-sC9iMwlM5Z9AmfK-XS-RPMBfg0V3c0tSJXlj8KFy0_0QytYApmp07LTzYClPcU6CEHXFc1MqZYw9e3ZCC4_RTI6QXz_mBZiMvut5omVXo3VksRhZkKQ7lJNKUPbNtSR8YK_kbkUG89gteXo9bBkZFOh-npp62kMDmJZj2kdiVvMow6qO27hzx_uZaWYXO_eB0UdqUNhKM-eVg0jJM_K3Wrd6RIFm-PyvxzDjO-Lr4nqk5IG7lT7eXSB9VLpZ5bzpLvwZXQ57omfuN8k9ApD-pSBW3KCt5mkpa9PQBjTFZpS62mRV_0-zRwjxaNo=w200-h200"));
//        techs.add(new TechModal("HTML5", "http://wampinfotech.com/image/htmllogo.png"));
        techs.add(new TechModal("CSS3", "https://lh3.googleusercontent.com/ZF6D2ha_VSN99aXHw9Q7dpU11vga1wJ-T_TXyP_pmQEtfuDIwiU0JnIzF7jJqUyHlH3l96VRSrzTwsh3GR6xIwTuaWDLdrIWs2ii9M_DnXOJUY_VJelkYYfmD3TjAMHnk1U83vKoh3yuajrdrwNS4kFThMk0dSVRu_XnmUI92Q7luYBz1miZGGPiMD95ZbIaMzjhWtALwyK-ZLTQ4Qxy3kpSh4PJPAX5rBQosekhXZo0NoURyjv-Bpq9_UpAwUb4eCFJC_9S6cJJzvrmK6KQ90zDBy0FDl2rvxLFKIv3ZcWPNaIscOMnt9QDkqRB-wbFj5cNgjcweMR_AAV56Z7IGpxYljbySmbOilulmAfP9Lzl9YFkqBfRrOgztmLQ2-m-B3K1iR0rNpvAtUUq508ege1JszRe0rjbs11zomQr0AwhP8mahQPxdKB-wW-qHammQzJ7sPWKRjDPPcX7utYwpMeg2TkbjzcuO-QPIpgqtT7PUTjmcRFr5OaeNRbZgA6mvZl0AwO5dMo-QX8fsTbZ1A6w6SPARgqy_vAepLQpsGOYmQ8Eip_oTwfIXm-giWHwcAES6f602dmh06cm9EyQe8v4PYy2Ns4i=w200-h200"));
//        techs.add(new TechModal("CSS3", "http://wampinfotech.com/image/csslogo.png"));
        techs.add(new TechModal("JavaScript", "https://lh3.googleusercontent.com/Dh2y5Bb9_hldb0Ao62Mavwp60787__0tiXf_dcniXyvk3GmHEEmjkf2gllnTuw9WtSXN7F6Zy3xm6835h2X6A_sopCboaB6QYynf_Sn5pLz1CWHBdk17Xd6at6-WHvR82cknKKPCVUA1_JHyUg7bUqyx1s3n5-O1BUW5G0RHPCfOeckroNUl32DJsSybg3GHqvlwxtDp9TeunpNH7IudLrjdXYVcAHVMs-lo0DxoBI1CSwNmh6vvl7cnNsc8k-FjsCTKNjAN8wCgqFdMrMmTU7kcaMiDz7F4wDInu-zjjji94XeIDpb9nSNDeoF6osaMsTKyHFXBsgbgH3FeG4ZzQrSTfTmUPIyOnMfl7pD7kQBNoAyEJUlf7tV46M_tcGFUizlprQMacadZ8-XvxwHzluydwulNQM6jFCKz49-M5FhJDqx2QfaNLX8VT2RjWgwAqO6ZRsf4Xme8KYwLTQ92wU2eJJeeWmMlqEnH3YrqVHMmL5d2rTlqw58WznkGHyi3FhunOciSYaUPJu0eC1Ub7A5JGvyYh5llWQVl7SrwpeQ8OhV9dDDGOuyYI1d7mZqmwRfMn4CTSFSN89I2N5H5qJrhXnt6Dj5K=w200-h200"));
//        techs.add(new TechModal("JavaScript", "https://wampinfotech.com/image/javascriptlogo.png"));
        techs.add(new TechModal("Bootstrap", "https://lh3.googleusercontent.com/E8sK_9g3eOavAfZnTb6bUQxjhdFLQStKi48Il5EQPMOI_oBfawpsn0f0vVaytyloCxM0TTiPcBaY0HKKdPYABsJduFZQkY0OyXQb1bwsGUWocnLOYDUakNWQwZIjWN2WPVjBi4RK0CjCN2x2z5Jtku6n6gLZh1wsqYkUXu_WQfjsAJg2lGRTPKObj2zjAJF_BgqE4cAI6fH1b4tnTils4mkC7Huy59eQ1vQNKlUs1mOz1bcf2zpTv97T8KClyMsa7gBol5o-9PeuDsiwI7tyrtBzR9892SRw65yRg0dSb0mh6Gfb_JjFH2ZnhO8Y1ZhIV44uKK8NGAROrySSjCO7wSvX1jr3yRcUg39Etkzmr83WNv5ihLJYPTttvaCjbiAZSlvZ3fGWhnqu-tQzqdXUsT0sajwpGnY5rMJkL8SQWuBl5AcBgE7DjReifCGzpdDpuDjX8scFQYZ3htOqNRD8pGzSdFX9kpuAFiE2jSJTby9ZipLaiozaV41Mcsqxetr2biUlvsUnSd_xvrM2pYEFZRVPsFipuvNY8KDtm8PTJzrl5iFH9XHAfSphm33Co1jezkZgJKkD7J-ddCGzJNDMvtUzxbKyvGWP=w200-h200"));
//        techs.add(new TechModal("Bootstrap", "https://wampinfotech.com/image/bootstraplogo.jpg"));
        techs.add(new TechModal("PHP", "https://lh3.googleusercontent.com/-aiHBQjzqwUTsi5gukQHFES03LfUWmaWPcSn2U9cF7JprxleRNFWpYWCNOiGFxHQ0SHr13ZiwubnmyJZMkmrZhERIkmqC-KGFpBd9Bw7UrBct_aJqODZ1nSl4_qMguY8N066eG_qEnJcbsB2NRbmg6WiewDTYDrl_YurGN3SRENlycyOhm76vGdoJ9Z1mbbt2hlUJL7fFkz-0xz-u2IHRhvl_VVVUmbKR5N7fTls-7SqfZTO32Hlo_JYeCIesiHlnx6v_ThlL5yAru3Xwad5BrBRaAjyZBPBf1y-G_ROo204PCfGJeAIGWNHUXz3WYkZm5dLk869h-eDDekIsGKkeXtCV10V5OCJXOslHmMO02Nk0WZpG0ahhzztAA9y3MJwblYv_e3LLIo90L0hzDqB1vPODe--2Ht8Cza0qSpTiOS3BN2zL9MiyrcjM11FeILxFsqnXn82OOF0he49sSf7vAi22LxCVCFtPyWeANHMxxYHm0KGDIRk_N6Xnrae7bJla9tLxIOBGTH8wU9ranpm3MVER9i0BOWTYR7GFOQdRVyfGmuUTmBx9XPi-KbmKlNGDXF8PuN0CjHuiit_SOCMwUjoiAij8hq8=w200-h200"));
//        techs.add(new TechModal("PHP", "http://wampinfotech.com/image/phplogo.png"));
        techs.add(new TechModal("MySQL", "https://lh3.googleusercontent.com/PEl0uWbL2sZXeVGz630W9jao3N0m5qyYgmILj0Sm3FiR3hNjhgCIQcCxTOqUbu6zIktKUY6g2Vw9ZCgfHVDe61wA_KzmtGcFKLF-xvKibS5_5jxBO-imXre_-07oGtlz5SKi2LAxVoqRpFBFh3pe9lp_Z5JvSserGqK5vg9yjSp5ElN7TRen4Zrk1CJzv6AAT-aMnxDX2OPeetjC7pJRr_aZAkfFiQTYUFJU4_EQJfCWz2mCyEavDMrUnpL8g7T0a3F6pBaXRCz9lJAQHIBH4LR1CYhFiy5cWRNsCISq3yIxFOTFfYotMCUM4xmGWowepwy8qCh9zQquc3lA5kmKphANE8r2FMut9KrBV9GN-EDgGi-rNqSx6ZKkhfz0QE97zSJ2xHrxwafLZ2kxRV6fwSeatON7tF9isVWHQcipjZdVkBrz9F0btmrJuWanvuKp3KXHFqpvUHVX-_toXI75O1jYheflZF_gDecevANAUeD_j-lFkgcg-lVePbNE-6kwIbFMfES3MunM-nnbVP9naKLgFXEe3uDD_jQFEW2p6aC7Y3davBbeWulqFTCqoecpzFNpwsyCS2b7Jwts5fq73GPRqBubN69A=w200-h200"));
        techs.add(new TechModal("ASP.NET", "https://lh3.googleusercontent.com/MfdpQcLnMMC-t3ao5czxFiopOCNalQ79hOm_OkSf8G-HOHad-LOqTO0rzyPfdgl6Neqa75jhaMWRto5bO4dLpPj4buYFafhLL1Ihw2s0-KrlJOLyMBKmteEtirtiv55jyDnene8q_7-21SEBXlsUzGPwaUfnO4ukDPDWi0Wg_ln01lyzTPQsoXPdYnL1ZWQFgWhMnz6O6DvnajHiiciLvsEmxLedUnhEpbv-UUEuqw_De9ix9nCMCT5XZIB5sCzIx0VlS1u10UF63Ryd100lWTrW3N35FPyGDFss-9QLOZV2D9Hq-XV7H-9tBv7Ieh4k5Dpe6nrAhCtZ6SBiUaoGH_EFkbovXIlhbkPwrMqy_kQ9kXpile7hQj6JEWsToDHNgddO8p5MjEV6nDHR5OpE7rbk-W1RscQzutwM0u-Mx3V__XtUt-xjDJn-x1rHoxxz3UH1BDhQhqeEH80zZKTsKi4Y0PEufcWnDk_-DEbT4whDVdOOsAt-_0QPPPp8ZZjpYqkbgJ07PcUxTKuxNMms79sKSnRJWS-VyHXdTugZFTubUHZzmeUvnNwfhAazTf63lVyGvtJW0JfEgU5kB6V3DnFFsfFfSgp1=w200-h200"));
//        techs.add(new TechModal("Java", "https://lh3.googleusercontent.com/vSR_c63eopcLMl6FMGbB0p-Elm5mp_9YspgCmbLTkiYm319AhuWfbXtypUk8j0Kmi2pdnz91mTY9LoiLZLZcBfW1dupFsIvEheeeJreT7fLtOMOHGdUaZWHAziTC6w28y6zaklx0SjNe92XlJ5T8f6hcsy88pC_bsdUevOPvMNkjubB79TU9MOsUOs8JVK2OzZUXjCNXwqjbYxevGMleFlJQUvfoZPu5FoFeluFE5KyfsbPY-rofoBX7e61RqZJXPt2kcO-c0NZmxFDMkpolYKiEPK5no_eNdqkB2T-wDTV8sKafQ3ollbMZRcdgwjtsEUsHdMPrBVNec9Pfy33OHedF7GYt64Lxyyz3K1rx2LH72mUawUdrEXS8-lSWSeRj_LGLgkw1gk8ctpZNqNzOKWF_-O5TluHEMnZtJSQTJG8xY2YPfLV0pu7XBE25fMhTxwYWNn_9J4sIcOwYNRtQqbnsj4QHUa8MeSWdA-tvm5pzgQSUFumlN9XHXwwb5W4HQPq5BpLQhp30-x_H9aby_W-NeXlR5WxXDWMZ8jQMbmG7cMY8Ma_V4IzghtbScEgtx7wZt4iaudvLiJET2HPv2QE7ir8t-9Bg=w1440-h709"));
        techs.add(new TechModal("Java", "https://lh3.googleusercontent.com/X0zawFZYwo8euDtPGYs6vs9IFGJfmMHmg7zC-YXKvOqf-1whfmSD1482ZPtJGs3xEPk82bcyAZWLkUMfKf7igoQTeFjR5Jl7unMnpsQ280IKq_bO-HK_69IYryHLr1XOArfs_U663Jpb7Tc0ObGVMNViJk80Ig-2yG2yoSG5el9puc3-kSv4mH-CdmI4B4Hxaj1Uqe6WuFp4xQ7OCTm3L1IhV8E13cCjgcQ037Zem9_JmAGAz32Mq3acKWKLfn2FiFRPd9YhPCCxI_r6z2LLvvEVFYk17lpXptWHPzFF8wQ-lYDFCheeioyo9se5Ncw1mKM38l6Z4y4HbM-ain-geIPJ1A0LksWN5LetOznnpzHTrafYXQBIDCMjv-wvUuIRck6a-3VG-pBhwGP5PfqEa6M8SJCvUAg3m18MSp-eSyDQKN_8TgNNI9m7I9Ybti7FBzLFH00umNy8z3r7k0r5m9H0NkP2u06E3t-j24p7AiWxjyGjYWdOwCkCOasJvsQwobYuDW8RCVPOwstgM0VYiUo26Xq1ZKH-ZFcH23zivzLyq0fyvyrehsflJtXYFiP7VnPSzKkpQm_-BAhe9XK5oNYgu2AQWhcJ=w200-h200"));

        ExGridView mAppsGrid = getView().findViewById(R.id.tech_list);
        mAppsGrid.setExpanded(true);
        mAppsGrid.setAdapter(new TechCardAdapter(this.getContext(), techs));
    }
}
