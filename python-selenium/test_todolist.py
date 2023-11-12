import sys
import pytest
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
   
@pytest.fixture(autouse=True)
def chrome_driver():
    driver = webdriver.Chrome()
    driver.get('https://lambdatest.github.io/sample-todo-app/')
    driver.maximize_window()

    yield driver

    driver.quit()


def test_navigation_to_lambdatest_todo_app(chrome_driver):
    title = "Sample page - lambdatest.com"
    assert title == chrome_driver.title
 
def test_adding_todo_item(chrome_driver):
    test_todo = "Clean the Upstairs Closet"

    chrome_driver.find_element(By.ID, "sampletodotext").send_keys(test_todo)
    chrome_driver.find_element(By.ID, "addbutton").click()

    new_item = chrome_driver.find_element(By.NAME, "li6")

    assert new_item != None

def test_completing_todo_item(chrome_driver):
    item2 = chrome_driver.find_element(By.NAME, "li2")
    item2_span = item2.find_element(By.XPATH, "/html/body/div/div/div/ul/li[2]/span")
    item2_not_done = item2_span.get_attribute('class')
    assert item2_not_done == 'done-false'
    
    item2.click()
    item2_done = item2_span.get_attribute('class')
    assert item2_done == 'done-true'
