package com.fitnessapp.presentation.views.discounts;

import android.widget.Toast;

import com.fitnessapp.R;
import com.fitnessapp.app.AbsPresenter;
import com.fitnessapp.app.App;
import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.data.model.StepEntity;
import com.fitnessapp.domain.interactors.DefaultObserver;
import com.fitnessapp.domain.interactors.usecases.FetchAllStepCounts;
import com.fitnessapp.domain.interactors.usecases.GetAllDiscountsUseCase;
import com.fitnessapp.domain.interactors.usecases.SaveDiscountUseCase;
import com.fitnessapp.domain.interactors.usecases.SaveStepCountUseCase;
import com.fitnessapp.presentation.views.home.HomePresenter;
import com.fitnessapp.utils.ResourcesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by carriagecompany on 9/25/17.
 */

public class DiscountsPresenter extends AbsPresenter<DiscountsContract.View> implements DiscountsContract.Actions {

    private GoogleApiClient mApiClient;

    private SaveDiscountUseCase saveStepCountUseCase;

    private GetAllDiscountsUseCase getAllDiscountsUseCase;

    @Inject
    public DiscountsPresenter(SaveDiscountUseCase saveStepCountUseCase,
                              GetAllDiscountsUseCase getAllDiscountsUseCase) {
        this.saveStepCountUseCase = saveStepCountUseCase;
        this.getAllDiscountsUseCase = getAllDiscountsUseCase;
    }


    @Override
    public void getDiscounts() {
         //addDummtDiscounts();
        getAllDiscountsUseCase.execute(new DiscountsPresenter.GetAllAvailableDiscount(), null);
    }


    @Override
    public void destroy() {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }


    private final class GetAllAvailableDiscount extends DefaultObserver<List<DiscountEntity>> {

        @Override
        public void onNext(List<DiscountEntity> discountEntities) {
            super.onNext(discountEntities);
            mView.showDiscounts(discountEntities);
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }


    void addDummtDiscounts() {


        DiscountEntity discountEntity1 = new DiscountEntity();

        discountEntity1.setStepCount(50);
        discountEntity1.setStoreName("LOADED SPAGHETTI");
        discountEntity1.setDesc("1 cup sliced bell pepper\n" +
                "1/2 cup sliced red onion\n" +
                "1 tsp olive oil\n" +
                "1 cup cooked whole-wheat spaghetti\n" +
                "2/3 cup cooked edamame\n" +
                "\n" +
                "Sauté peppers and onions in oil until onions are translucent. Toss with pasta and edamame.\n" +
                "\n");
        discountEntity1.setImage("https://www.womenshealthmag.com/sites/womenshealthmag.com/files/styles/listicle_slide_custom_user_desktop_1x/public/images/1405-dinner.jpg");
        discountEntity1.setMealName("LOADED SPAGHETTI");
        discountEntity1.setPrice(100);
        discountEntity1.setPercentage(10);


        DiscountEntity discountEntity2 = new DiscountEntity();
        discountEntity2.setStepCount(60);
        discountEntity2.setStoreName("BEEF AND VEGGIE SALAD BOWL");
        discountEntity2.setDesc("2 Tbsp dry red quinoa\n" +
                "2 cups mesclun greens\n" +
                "3 oz cooked lean beef, cubed\n" +
                "1/2 cup chopped broccoli florets\n" +
                "1/4 red bell pepper, chopped\n" +
                "2 tsp olive oil\n" +
                "1 tsp red wine vinegar\n" +
                "\n");
        discountEntity2.setImage("https://www.womenshealthmag.com/sites/womenshealthmag.com/files/styles/listicle_slide_custom_user_desktop_1x/public/images/fast-past-6_0.jpg");
        discountEntity2.setMealName("BEEF AND VEGGIE SALAD BOWL");
        discountEntity2.setPrice(80);
        discountEntity2.setPercentage(20);


        DiscountEntity discountEntity3 = new DiscountEntity();
        discountEntity3.setStepCount(70);
        discountEntity3.setStoreName("HALF-HOMEMADE SOUP WITH ASPARAGUS");
        discountEntity3.setDesc("2 Tbsp dry red quinoa\n" +
                "2 cups mesclun greens\n" +
                "3 oz cooked lean beef, cubed\n" +
                "1/2 cup chopped broccoli florets\n" +
                "1/4 red bell pepper, chopped\n" +
                "2 tsp olive oil\n" +
                "1 tsp red wine vinegar\n" +
                "\n");
        discountEntity3.setImage("https://www.womenshealthmag.com/sites/womenshealthmag.com/files/styles/listicle_slide_custom_user_desktop_1x/public/images/1403-fbd.jpg");
        discountEntity3.setMealName("HALF-HOMEMADE SOUP WITH ASPARAGUS");
        discountEntity3.setPrice(90);
        discountEntity3.setPercentage(20);

        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity1));

        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity2));

        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity3));

    }


    private final class SaveDiscount extends DefaultObserver<Void> {

        @Override
        public void onNext(Void aVoid) {
            super.onNext(aVoid);
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }


}
