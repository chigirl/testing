using Microsoft.Playwright;
using Microsoft.Playwright.NUnit;

namespace LambdaToDoTests;

public class Tests : PageTest
{
    [SetUp]
    public async Task Setup()
    {
        await Page.GotoAsync("https://lambdatest.github.io/sample-todo-app/");
    }

    [Test]
    public async Task TestTitle()
    {
        String title = "Sample page - lambdatest.com";
        await Expect(Page).ToHaveTitleAsync(title);

    }

     [Test]
    public async Task TestAddToDo()
    {
        var TodoText = "Clean Hall Closet";
        var ToDoTextbox = Page.Locator("#sampletodotext");
        await ToDoTextbox.FillAsync(TodoText);
        await Page.Locator("#addbutton").ClickAsync();
       
        var newItem = Page.Locator("[name='li6']");
        await Expect(newItem).ToBeVisibleAsync();
    }

    [Test]
    public async Task TestMarkToDoDone()
    {
        var Item2 =  Page.Locator("xpath=/html/body/div/div/div/ul/li[2]");
        var Item2Checkbox = Item2.Locator("[name=li2]");
        var Item2Span = Item2.GetByText("Second Item");
        await Expect(Item2Span).ToHaveClassAsync("done-false");
        await Item2Checkbox.ClickAsync();
         await Expect(Item2Span).ToHaveClassAsync("done-true");
    }
}