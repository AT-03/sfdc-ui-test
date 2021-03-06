package org.fundacionjala.sfdc.pages.lookup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * Class to represent the Search popup.
 */
class SearchSectionFrame extends AbstractBasePage {


    @FindBy(id = "searchFrame")
    private WebElement searchSection;

    @FindBy(id = "campaignScope")
    private WebElement campaignScopeSelect;

    @FindBy(id = "lksrch")
    private WebElement campaignNameField;

    @FindBy(name = "go")
    private WebElement searchButton;

    /**
     * Method that select the search popup.
     */
    SearchSectionFrame() {
        driver.switchTo().frame(0);
        ExpectedConditions.frameToBeAvailableAndSwitchToIt(searchSection);
    }

    /**
     * Method that set the campaign to make the search in the popup.
     *
     * @param campaign String with the Campaign name.
     */
    public void setCampaign(final String campaign) {
        setCampaignName(campaign);
        clickSearch();
        CommonActions.returnRoot();
    }

    /**
     * Method that sets the se scope and the parent campaign to make the search.
     *
     * @param parentCampaign String with the Campaign name.
     * @param scope          String with the scope data.
     */
    void searchTheCampaign(final String parentCampaign, final String scope) {
        setCampaignScope(scope);
        setCampaign(parentCampaign);
    }

    /**
     * Method that sets the se scope and the parent campaign to make the search.
     *
     * @param campaign String with the Campaign name.
     */
    void searchTheCampaign(final String campaign) {
        setCampaign(campaign);
    }

    /**
     * Method that makes a click on the Search icon.
     */
    private void clickSearch() {
        wait.until(ExpectedConditions.visibilityOf(this.searchButton));
        searchButton.click();
    }

    /**
     * Method to sets the campaign scope in the search popup.
     *
     * @param campaignScope String with the campaign scope info.
     */
    private void setCampaignScope(final String campaignScope) {
        wait.until(ExpectedConditions.visibilityOf(this.campaignScopeSelect));
        Select newCampaignScopeSelect = new Select(this.campaignScopeSelect);
        newCampaignScopeSelect.selectByVisibleText(campaignScope);
    }

    /**
     * Method to sets the campaign name to search.
     *
     * @param campaignName String with the campaign name.
     */
    private void setCampaignName(final String campaignName) {
        wait.until(ExpectedConditions.visibilityOf(this.campaignNameField));
        this.campaignNameField.clear();
        this.campaignNameField.sendKeys(campaignName);
    }
}
