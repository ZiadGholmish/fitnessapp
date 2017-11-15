package com.fitnessapp.presentation.views.discounts;

import com.fitnessapp.app.AbsPresenter;
import com.fitnessapp.data.model.DiscountEntity;
import com.fitnessapp.domain.interactors.DefaultObserver;
import com.fitnessapp.domain.interactors.usecases.GetAllDiscountsUseCase;
import com.fitnessapp.domain.interactors.usecases.SaveDiscountUseCase;
import com.fitnessapp.domain.model.DiscountModel;
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
        addDummtDiscounts();
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


    private final class GetAllAvailableDiscount extends DefaultObserver<List<DiscountModel>> {

        @Override
        public void onNext(List<DiscountModel> discountEntities) {
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


        DiscountModel discountEntity1 = new DiscountModel();

        discountEntity1.setId(1);
        discountEntity1.setStepCount(50);
        discountEntity1.setStoreName("Diet Center");
        discountEntity1.setStoreLogo("http://www.dietcenterme.com/img/logo.png");
        discountEntity1.setCardImage("http://greenlifedietcenter.com/wp-content/uploads/2014/07/Slider3.jpg");
        discountEntity1.setDesc("We are committed to transforming people’s lives!\n" +
                "We help you introduce more balance into your lives, eat well, move more and live life.");
        discountEntity1.setCardOverlayColor("#99000000");
        discountEntity1.setPrice(75);
        discountEntity1.setPercentage(25);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity1));


        DiscountModel discountEntity2 = new DiscountModel();
        discountEntity2.setId(2);
        discountEntity2.setStepCount(200);
        discountEntity2.setStoreName("Gold's Gym");
        discountEntity2.setStoreLogo("http://riverdaleparkstation.com/wp-content/uploads/2017/03/golds-gym.jpg");
        discountEntity2.setCardImage("http://www.goldsgym.com/wp-content/uploads/2017/07/classes-call.jpg");
        discountEntity2.setDesc("A History Rooted in Strength\n" +
                "Strength comes in many forms, and since 1965, we’ve helped people around the world find theirs. When Joe Gold opened the first Gold’s Gym at the world famous Venice Beach, he began a tradition of commitment, passion and dedication that is still practiced today. Today we continue that tradition of being the forefront of personal fitness.");
        discountEntity2.setCardOverlayColor("#99000000");
        discountEntity2.setPrice(150);
        discountEntity2.setPercentage(15);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity2));


        DiscountModel discountEntity3 = new DiscountModel();
        discountEntity3.setId(3);
        discountEntity3.setStepCount(200);
        discountEntity3.setStoreName("Jazeera Airways");
        discountEntity3.setStoreLogo("http://www.jazeeraairways.com/assets/images/aero_logo.png");
        discountEntity3.setCardImage("http://www.jazeeraairways.com/asset_stock/NewDubai_1600X450_EN.jpg");
        discountEntity3.setDesc("As the largest private airline operating out of Kuwait, we strive to provide a seamless travel experience to all our passengers.");
        discountEntity3.setCardOverlayColor("#99000000");
        discountEntity3.setPrice(200);
        discountEntity3.setPercentage(20);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity3));


        DiscountModel discountEntity4 = new DiscountModel();
        discountEntity4.setId(4);
        discountEntity4.setStepCount(100);
        discountEntity4.setStoreName("Ministry of State for Youth Affairs");
        discountEntity4.setStoreLogo("http://www.youth.gov.kw/AR/images/logo.png");
        discountEntity4.setCardImage("http://www.youth.gov.kw/webImage/banner_images/20171015121102.jpg");
        discountEntity4.setDesc("Any national goal or aspiration depends upon a nation’s youth. This reliance is the cornerstone of progress. " +
                "Thus, numerous countries have prepared strategies for their young citizens. They have held conferences, forums, and committees to develop services that benefit the young.");
        discountEntity4.setCardOverlayColor("#99000000");
        discountEntity4.setPrice(5);
        discountEntity4.setPercentage(50);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity4));


        DiscountModel discountEntity5 = new DiscountModel();
        discountEntity5.setId(5);
        discountEntity5.setStepCount(300);
        discountEntity5.setStoreName("Flex Gym");
        discountEntity5.setStoreLogo("http://www.flexq8.com/wp-content/uploads/2017/04/flexlogo.png");
        discountEntity5.setCardImage("http://flexq8.com/wp-content/uploads/flexexecutive.jpg");
        discountEntity5.setDesc("It all started over 25-years ago when a Kuwaiti-based gym, Flex Fitness for men, opened its doors in the basement of a building in Bneid Al Gar. Driven by the passion of providing the highest physical fitness and health standards, Flex Fitness stood out, by securing a place among the leaders in the healthy living and fitness sector in Kuwait, in a short period of time.");
        discountEntity5.setCardOverlayColor("#99000000");
        discountEntity5.setPrice(90);
        discountEntity5.setPercentage(40);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity5));


        DiscountModel discountEntity6 = new DiscountModel();
        discountEntity6.setId(6);
        discountEntity6.setStepCount(300);
        discountEntity6.setStoreName("Champ World Wide");
        discountEntity6.setStoreLogo("http://www.champworldwide.com/images/logo.png");
        discountEntity6.setCardImage("http://www.champworldwide.com/images/gallery/gallery3.jpg");
        discountEntity6.setDesc("The Champion is committed to excellence in service, Established in 1993, it remains " +
                "a well known and Best Health, Wellness and Beauty Center located in the heart of Kuwait. Owned and Manage by an individual who " +
                "specialized in wellness and fitness, studied and got his degree in America.");
        discountEntity6.setCardOverlayColor("#99000000");
        discountEntity6.setPrice(210);
        discountEntity6.setPercentage(45);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity6));


        DiscountModel discountEntity7 = new DiscountModel();
        discountEntity7.setId(7);
        discountEntity7.setStepCount(300);
        discountEntity7.setStoreName("Platinum KW");
        discountEntity7.setStoreLogo("http://www.platinumkw.com/templates/images/main-logo.gif");
        discountEntity7.setCardImage("http://www.platinumkw.com/templates/images/img_3.png");
        discountEntity7.setDesc("Congratulations on making the important decision, to take the first steps to a healthier, fitter you. We're delighted you're considering PLATINUM Health Club.");
        discountEntity7.setCardOverlayColor("#99000000");
        discountEntity7.setPrice(155);
        discountEntity7.setPercentage(23);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity7));

        DiscountModel discountEntity8 = new DiscountModel();
        discountEntity8.setId(8);
        discountEntity8.setStepCount(300);
        discountEntity8.setStoreName("Spark Athletic");
        discountEntity8.setStoreLogo("https://static.wixstatic.com/media/e01d1f_b0acb340a0dc40dbb61812cc5db7a67f~mv2.png/v1/fill/w_348,h_123,al_c,usm_0.66_1.00_0.01/e01d1f_b0acb340a0dc40dbb61812cc5db7a67f~mv2.png");
        discountEntity8.setCardImage("https://static.wixstatic.com/media/e01d1f_bc3faa628bf04f0bbd478b72992b2fc6~mv2_d_5184_3456_s_4_2.jpg/v1/fill/w_3645,h_2430,al_c,q_90,usm_0.66_1.00_0.01/e01d1f_bc3faa628bf04f0bbd478b72992b2fc6~mv2_d_5184_3456_s_4_2.jpg");
        discountEntity8.setDesc("SPARK Athletic Center Kuwait’s leader in integrated sport performance training, nutrition, and physical therapy for professional athletes ");
        discountEntity8.setCardOverlayColor("#99000000");
        discountEntity8.setPrice(350);
        discountEntity8.setPercentage(10);
        saveStepCountUseCase.execute(new DiscountsPresenter.SaveDiscount(),
                SaveDiscountUseCase.Params.forSaveDiscount(discountEntity8));

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
