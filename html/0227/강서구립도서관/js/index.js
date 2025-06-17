function changeTab(tabId) {
    const allTabs = document.querySelectorAll('.tab');
    const allContent = document.querySelectorAll('.tab-content');

    allTabs.forEach(function(tab){
       tab.classList.remove('active-tab');
       //모든 tab을 순환하면서 class명 active-tab 제거
    });
    allContent.forEach(function(content){
        content.classList.remove('active-content');
       //모든 tab을 순환하면서 class명 active-content 제거
    });

    // const selectedTab = document.getElementsByClassName('menu' + tabId);
    // selectedTab.classList.add('active-tab');

    // const selectedContent = document.getElementsByClassName(tabId);
    // selectedContent.classList.add('active-content');
}