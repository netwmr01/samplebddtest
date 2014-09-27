package test.example;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import samplebddtest.Game;
import samplebddtest.StringRenderer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GridSteps { // Look, Ma', I'm a POJO!
    
    private Game game;
    private StringRenderer renderer;
 
    @Given("给定一个 $width 乘 $height 的游戏")
    @Aliases(values={"a new game: $width by $height"})
    public void theGameIsRunning(int width, int height) {
        game = new Game(width, height);
        renderer = new StringRenderer();
        game.setObserver(renderer);
    }
     
    @When("当我点击了 ($column, $row) 这个位置的时候")
    public void iToggleTheCellAt(int column, int row) {
        game.toggleCellAt(column, row);
    }
     
    @Then("游戏棋盘应该像以下这样子 $grid")
    @Aliases(values={"the grid should be $grid"})
    public void theGridShouldLookLike(String grid) {
        assertThat(renderer.asString(), equalTo(grid));
    }
 
}