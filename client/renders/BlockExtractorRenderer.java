package mods.nordwest.client.renders;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockExtractorRenderer extends BlockRenderer implements ISimpleBlockRenderingHandler {
	float w1 = 0.3120f;
	float w2 = 0.5620f;
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		drawFaces(renderer, block, true);
		
		block.setBlockBounds(0, 0.0F, 0, w1, w2, w1);
		renderer.setRenderBoundsFromBlock(block);
		drawFaces(renderer, block, true);

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		
		block.setBlockBounds(0, 0.0F, 0, w1, w2, w1);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		
		block.setBlockBounds(1-w1, 0.0F, 0, 1f, w2, w1);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		
		block.setBlockBounds(0, 0.0F, 1-w1, w1, w2, 1);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		
		block.setBlockBounds( 1-w1, 0.0F,  1-w1, 1f, w2, 1f);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		
	
		
		
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return mods.nordwest.common.Config.ExtractorRendererID;
	}

	public void drawFaces(RenderBlocks renderblocks, Block block, boolean solidtop) {
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderblocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 0));
		tessellator.draw();
		if (solidtop)
			GL11.glDisable(3008);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderblocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 1));
		tessellator.draw();
		if (solidtop)
			GL11.glEnable(3008);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderblocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 2));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderblocks.renderWestFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 3));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderblocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 4));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderblocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 5));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
}
