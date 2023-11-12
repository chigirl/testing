describe('Exercise Lambda To Do List', () => {
  beforeEach(() => {
    cy.visit('https://lambdatest.github.io/sample-todo-app')
  })

  
  it('should have title', () => {
     cy.title()
      .should("eq", "Sample page - lambdatest.com");
  })

  it('should add a To Do item', () => {
    cy.get("#sampletodotext")
      .type("Clean upstairs closet")
    cy.get("#addbutton").click()
    cy.get('input[name="li6"]')
      .should("exist")
  })

  it('should complete To Do item', () => {
    cy.get('input[name="li2"]').as('item2')
    cy.contains('Second Item').as('item2span')
    cy.get('@item2span').should('have.class', 'done-false')
    cy.get('@item2').click()
    cy.get('@item2span')
    cy.get('@item2span').should('have.class', 'done-true')
  })


})